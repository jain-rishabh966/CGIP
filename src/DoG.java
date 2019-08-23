import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DoG {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat img1,img2,img3 = new Mat();
		img1 = Imgcodecs.imread("1.jpg");
		img2 = Imgcodecs.imread("1.jpg");
		Size s1 = new Size();
		s1.height = 33;
		s1.width = 33;
		Size s2 = new Size();
		s2.height = 3;
		s2.width = 3;
		
		Imgproc.GaussianBlur(img1, img1, s1, 0);
		Imgproc.GaussianBlur(img2, img2, s2, 0);
		Core.subtract(img2, img1, img3);
		
		HighGui.imshow("img3", img3);
		Mat m = new Mat();
		Core.add(img1, img3, m);
		HighGui.imshow("DoG", m);
		HighGui.waitKey(0);
		HighGui.destroyAllWindows();
		System.exit(0);
	}
}
