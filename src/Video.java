import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class Video {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		VideoCapture v = new VideoCapture(0);
		
		Mat src = new Mat();
		
		v.read(src);
		Imgcodecs.imwrite("Video.jpg", src);
		
		while(true){
			v.read(src);
			HighGui.imshow("Video", src);
			int k = HighGui.waitKey(5);
			if(k==27){
				v.release();
				break;
			}
		}
		HighGui.destroyAllWindows();
		System.exit(0);
	}
}
