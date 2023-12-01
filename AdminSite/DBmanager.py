import pymysql
from configs import library_database, library_login_database, library_password_database
import os.path as pt


class DBManager:
    def __init__(self):
        self.db_connectionn = pymysql.connect(
            'localhost', library_login_database, library_password_database, library_database, autocommit=True)
        self.init_tables()

    def init_tables(self):
        cur = self.db_connectionn.cursor()
        for sql in open('AdminSite/sql/tables-schema.sql').read().split('\n'):
            cur.execute(sql)
        cur.close()

    def cleanup_database(self):
        cursor = self.db_connectionn.cursor()
        cursor.execute("DROP TABLE librarians;")
        cursor.execute('DROP TABLE sessions;')
        cursor.close()

    def get_user(self, login, hash_passwd):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT * FROM librarians WHERE login=%s AND password=%s;", (login, hash_passwd,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def get_user_by_id(self, user_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT * FROM librarians WHERE id=%s;", (user_id,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def create_user(self, user):
        cursor = self.db_connectionn.cursor()
        cursor.execute(
            "INSERT INTO librarians(login,password,name,phone,address,privilege) VALUES (%s,%s,%s,%s,%s,%s);",
            (user['login'], user['passwd'], user['name'], user['phone'], user['address'], user['privilege'],))
        cursor.close()

    def get_user_id(self, login, hash_passwd):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT (id) FROM librarians WHERE login=%s AND password=%s;", (login, hash_passwd,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def create_session(self, session_id, user_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("INSERT INTO sessions VALUES (%s,%s);", (session_id, user_id,))
        cursor.close()

    def get_user_id_by_session(self, session_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT user_id FROM sessions WHERE id=%s;", (session_id,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def delete_session(self, session_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("DELETE FROM sessions WHERE id=%s;", (session_id,))
        cursor.close()

    def get_users(self):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT id,name,phone,address,privilege FROM librarians;")
        res = cursor.fetchall()
        cursor.close()
        return res

    def get_user_by_name(self, name):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT id,name,phone,address FROM librarians WHERE name=%s;", (name,))
        res = cursor.fetchall()
        cursor.close()
        return res

    def insert_verification_string(self, string, privilege):
        cursor = self.db_connectionn.cursor()
        cursor.execute("INSERT INTO verification_string VALUES(%s,0,1,%s);", (string, privilege,))
        cursor.close()

    def if_verification_string_exist(self, string, status):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT * FROM verification_string WHERE string=%s AND is_authentication=%s;", (string, status,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def activate_verification_string(self, string, user_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute(
            "UPDATE verification_string SET is_authentication=%s, user_id=%s WHERE string=%s;",
            (0, user_id[0], string,))
        cursor.close()

    def all_verification_strings(self, status):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT * FROM verification_string WHERE is_authentication=%s;", (status,))
        res = cursor.fetchall()
        cursor.close()
        return res

    def get_verification_string(self, user_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT string FROM verification_string WHERE is_authentication=0 AND user_id=%s", (user_id,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def get_privilege_by_verification_string(self, verification_string):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT privilege FROM verification_string WHERE string=%s;", (verification_string,))
        res = cursor.fetchone()
        cursor.close()
        return res

    def get_privilege_by_user_id(self, user_id):
        cursor = self.db_connectionn.cursor()
        cursor.execute("SELECT privilege FROM librarians WHERE id=%s", (user_id,))
        res = cursor.fetchone()
        cursor.close()
        return res
