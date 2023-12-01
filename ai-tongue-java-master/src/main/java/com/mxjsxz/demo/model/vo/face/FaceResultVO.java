package com.mxjsxz.demo.model.vo.face;

import java.util.List;

/**
 * @author xuwenbing
 * @date 2022-7-4
 */
public class FaceResultVO {
    /**
     * 面色，目前只有一个特征
     * <pre>
     * {
     *  "code": "m-10",
     *  "name": "***",
     *  "description": "***"
     * }
     * </pre>
     */
    private FaceCharacterVO mianse;

    /**
     * 主色
     */
    private FaceCharacterVO zhuse;

    /**
     * 光泽
     */
    private FaceCharacterVO guangze;

    /**
     * 黑眼圈（左眼）
     */
    private FaceCharacterVO heiyanquanLeft;


    /**
     * 黑眼圈（右眼）
     */
    private FaceCharacterVO heiyanquanRight;

    /**
     * 唇色
     */
    private FaceCharacterVO chunse;

    /**
     * 眼神
     */
    private FaceCharacterVO yanshen;

    /**
     * 左眼目色
     */
    private FaceCharacterVO museLeft;

    /**
     * 右眼目色
     */
    private FaceCharacterVO museRight;

    /**
     * 两颧红
     */
    private FaceCharacterVO liangquanhong;

    /**
     * 鼻褶
     */
    private FaceCharacterVO bizhe;

    /**
     * 眉间/鼻柱青色
     */
    private FaceCharacterVO meijianqing;

    /**
     * 面部皮损
     */
    private List<FaceCharacterVO> mianbuPiSun;

    /**
     * 耳色(左耳)
     */
    private FaceCharacterVO erseLeft;

    /**
     * 耳色(右耳)
     */
    private FaceCharacterVO erseRight;

    /**
     * 耳褶(左耳)
     */
    private FaceCharacterVO erzheLeft;

    /**
     * 耳褶(右耳)
     */
    private FaceCharacterVO erzheRight;

    /**
     * 过程图
     */
    private ProcessImage processImage;

    /**
     * 计算图
     */
    private CaluateImage caluateImage;

    /**
     * 过程图
     */
    public static class ProcessImage {

        /**
         * 五官标注图,形如：https://hangzhou.aliyun.com/ai/process/face_area_label/2022/06/***.png
         */
        private String faceAreaLabel;

        /**
         * 主面部异物图
         */
        private String faceAbnormal;

        /**
         * 鼻褶标注图
         */
        private String faceBzxz;

        /**
         * 主面部图打码图
         */
        private String mainMosaic;

        /**
         * 左面部异物图
         */
        private String leftSidefaceAbnormal;

        /**
         * 右面部异物图
         */
        private String rightSidefaceAbnormal;

        /**
         * 左耳褶标注图
         */
        private String leftFaceEzxz;

        /**
         * 右耳褶标注图
         */
        private String rightFaceEzxz;

        public String getFaceAreaLabel() {
            return faceAreaLabel;
        }

        public void setFaceAreaLabel(String faceAreaLabel) {
            this.faceAreaLabel = faceAreaLabel;
        }

        public String getFaceAbnormal() {
            return faceAbnormal;
        }

        public void setFaceAbnormal(String faceAbnormal) {
            this.faceAbnormal = faceAbnormal;
        }

        public String getFaceBzxz() {
            return faceBzxz;
        }

        public void setFaceBzxz(String faceBzxz) {
            this.faceBzxz = faceBzxz;
        }

        public String getMainMosaic() {
            return mainMosaic;
        }

        public void setMainMosaic(String mainMosaic) {
            this.mainMosaic = mainMosaic;
        }

        public String getLeftSidefaceAbnormal() {
            return leftSidefaceAbnormal;
        }

        public void setLeftSidefaceAbnormal(String leftSidefaceAbnormal) {
            this.leftSidefaceAbnormal = leftSidefaceAbnormal;
        }

        public String getRightSidefaceAbnormal() {
            return rightSidefaceAbnormal;
        }

        public void setRightSidefaceAbnormal(String rightSidefaceAbnormal) {
            this.rightSidefaceAbnormal = rightSidefaceAbnormal;
        }

        public String getLeftFaceEzxz() {
            return leftFaceEzxz;
        }

        public void setLeftFaceEzxz(String leftFaceEzxz) {
            this.leftFaceEzxz = leftFaceEzxz;
        }

        public String getRightFaceEzxz() {
            return rightFaceEzxz;
        }

        public void setRightFaceEzxz(String rightFaceEzxz) {
            this.rightFaceEzxz = rightFaceEzxz;
        }
    }


    /**
     * 计算图
     */
    public static class CaluateImage {
        /**
         * 面部分割图,形如：https://hangzhou.aliyun.com/ai/caluate/face_split/2022/06/***.png
         */
        private String faceSplit;

        /**
         * 双眼图
         */
        private String doubleEye;

        /**
         * 左眼图
         */
        private String leftEye;

        /**
         * 右眼图
         */
        private String rightEye;

        /**
         * 矩形嘴唇图
         */
        private String rectLip;

        /**
         * 左耳图
         */
        private String leftEars;

        /**
         * 右耳图
         */
        private String rightEars;

        public String getFaceSplit() {
            return faceSplit;
        }

        public void setFaceSplit(String faceSplit) {
            this.faceSplit = faceSplit;
        }

        public String getDoubleEye() {
            return doubleEye;
        }

        public void setDoubleEye(String doubleEye) {
            this.doubleEye = doubleEye;
        }

        public String getLeftEye() {
            return leftEye;
        }

        public void setLeftEye(String leftEye) {
            this.leftEye = leftEye;
        }

        public String getRightEye() {
            return rightEye;
        }

        public void setRightEye(String rightEye) {
            this.rightEye = rightEye;
        }

        public String getRectLip() {
            return rectLip;
        }

        public void setRectLip(String rectLip) {
            this.rectLip = rectLip;
        }

        public String getLeftEars() {
            return leftEars;
        }

        public void setLeftEars(String leftEars) {
            this.leftEars = leftEars;
        }

        public String getRightEars() {
            return rightEars;
        }

        public void setRightEars(String rightEars) {
            this.rightEars = rightEars;
        }
    }

    public FaceCharacterVO getMianse() {
        return mianse;
    }

    public void setMianse(FaceCharacterVO mianse) {
        this.mianse = mianse;
    }

    public FaceCharacterVO getZhuse() {
        return zhuse;
    }

    public void setZhuse(FaceCharacterVO zhuse) {
        this.zhuse = zhuse;
    }

    public FaceCharacterVO getGuangze() {
        return guangze;
    }

    public void setGuangze(FaceCharacterVO guangze) {
        this.guangze = guangze;
    }

    public FaceCharacterVO getHeiyanquanLeft() {
        return heiyanquanLeft;
    }

    public void setHeiyanquanLeft(FaceCharacterVO heiyanquanLeft) {
        this.heiyanquanLeft = heiyanquanLeft;
    }

    public FaceCharacterVO getHeiyanquanRight() {
        return heiyanquanRight;
    }

    public void setHeiyanquanRight(FaceCharacterVO heiyanquanRight) {
        this.heiyanquanRight = heiyanquanRight;
    }

    public FaceCharacterVO getChunse() {
        return chunse;
    }

    public void setChunse(FaceCharacterVO chunse) {
        this.chunse = chunse;
    }

    public FaceCharacterVO getYanshen() {
        return yanshen;
    }

    public void setYanshen(FaceCharacterVO yanshen) {
        this.yanshen = yanshen;
    }

    public FaceCharacterVO getMuseLeft() {
        return museLeft;
    }

    public void setMuseLeft(FaceCharacterVO museLeft) {
        this.museLeft = museLeft;
    }

    public FaceCharacterVO getMuseRight() {
        return museRight;
    }

    public void setMuseRight(FaceCharacterVO museRight) {
        this.museRight = museRight;
    }

    public FaceCharacterVO getLiangquanhong() {
        return liangquanhong;
    }

    public void setLiangquanhong(FaceCharacterVO liangquanhong) {
        this.liangquanhong = liangquanhong;
    }

    public FaceCharacterVO getBizhe() {
        return bizhe;
    }

    public void setBizhe(FaceCharacterVO bizhe) {
        this.bizhe = bizhe;
    }

    public FaceCharacterVO getMeijianqing() {
        return meijianqing;
    }

    public void setMeijianqing(FaceCharacterVO meijianqing) {
        this.meijianqing = meijianqing;
    }

    public List<FaceCharacterVO> getMianbuPiSun() {
        return mianbuPiSun;
    }

    public void setMianbuPiSun(List<FaceCharacterVO> mianbuPiSun) {
        this.mianbuPiSun = mianbuPiSun;
    }

    public FaceCharacterVO getErseLeft() {
        return erseLeft;
    }

    public void setErseLeft(FaceCharacterVO erseLeft) {
        this.erseLeft = erseLeft;
    }

    public FaceCharacterVO getErseRight() {
        return erseRight;
    }

    public void setErseRight(FaceCharacterVO erseRight) {
        this.erseRight = erseRight;
    }

    public FaceCharacterVO getErzheLeft() {
        return erzheLeft;
    }

    public void setErzheLeft(FaceCharacterVO erzheLeft) {
        this.erzheLeft = erzheLeft;
    }

    public FaceCharacterVO getErzheRight() {
        return erzheRight;
    }

    public void setErzheRight(FaceCharacterVO erzheRight) {
        this.erzheRight = erzheRight;
    }

    public ProcessImage getProcessImage() {
        return processImage;
    }

    public void setProcessImage(ProcessImage processImage) {
        this.processImage = processImage;
    }

    public CaluateImage getCaluateImage() {
        return caluateImage;
    }

    public void setCaluateImage(CaluateImage caluateImage) {
        this.caluateImage = caluateImage;
    }
}
