package FaceDetectSync;
interface FaceDetectInterface {
	
	//人脸检测接口，输入人像灰度图，得到人脸框，与人脸个数，并该接口的调用时阻塞式的（同步调用）
	int faceDetect(in byte[] grayImage, int width, 
		int height, out int[] faceRect, out int[] faceNum);
			
	int	initSDK();
	int extractFeat(in byte[] grayPic, int width, int height ,out byte[] faceFeature);
	int exFeatFormFile(String fileName, out byte[] faceFeatrue);
	//1vN人脸比对
	int faceMatch_1vN(in byte[] srcFeat, in byte[] mutiFeat, out float[] matchScore);
	int faceMatch_1vn(in byte[] srcFeat, in List mutiFeat, out float[] matchScore);
	int jniRGB565toGray(in byte[] byRGBImage, out byte[] byGrayImage, int nImgWidth, int nImgHeight);
	int jniARGBtoGray(in byte[] byRGBImage, out byte[] byGrayImage, int nImgWidth, int nImgHeight );
}