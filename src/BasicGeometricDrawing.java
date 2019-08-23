import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.*;
import java.util.List;

class GeometricDrawingRun {

	private static final int W = 400;

	public void run() {
		String a = "Atom";
		Mat a_image = Mat.zeros(W, W, CvType.CV_8UC3);
		MyEllipse(a_image, 190.0);
		
		MyFilledCircle(a_image, new Point(W / 2, W / 2));
		HighGui.imshow(a, a_image);
		Imgcodecs.imwrite("A.jpg", a_image);
		HighGui.moveWindow(a, 0, 200);
		HighGui.waitKey(0);
		System.exit(0);
	}

	private void MyEllipse(Mat img, double angle) {
		Imgproc.ellipse(img, new Point(W / 2, W / 2), new Size(W / 4, W / 16), angle, 0.0, 360.0, new Scalar(255, 0, 0),
				1, 8, 0);
	}

	private void MyFilledCircle(Mat img, Point center) {
		Imgproc.circle(img, center, W / 32, new Scalar(0, 0, 255), -1, 8, 0);
	}

	@SuppressWarnings("unused")
	private void MyPolygon(Mat img) {
		Point[] pt = new Point[20];
		pt[0] = new Point(W / 4, 7 * W / 8);
		pt[1] = new Point(3 * W / 4, 7 * W / 8);
		pt[2] = new Point(3 * W / 4, 13 * W / 16);
		pt[3] = new Point(11 * W / 16, 13 * W / 16);
		pt[4] = new Point(19 * W / 32, 3 * W / 8);
		pt[5] = new Point(3 * W / 4, 3 * W / 8);
		pt[6] = new Point(3 * W / 4, W / 8);
		pt[7] = new Point(26 * W / 40, W / 8);
		pt[8] = new Point(26 * W / 40, W / 4);
		pt[9] = new Point(22 * W / 40, W / 4);
		pt[10] = new Point(22 * W / 40, W / 8);
		pt[11] = new Point(18 * W / 40, W / 8);
		pt[12] = new Point(18 * W / 40, W / 4);
		pt[13] = new Point(14 * W / 40, W / 4);
		pt[14] = new Point(14 * W / 40, W / 8);
		pt[15] = new Point(W / 4, W / 8);
		pt[16] = new Point(W / 4, 3 * W / 8);
		pt[17] = new Point(13 * W / 32, 3 * W / 8);
		pt[18] = new Point(5 * W / 16, 13 * W / 16);
		pt[19] = new Point(W / 4, 13 * W / 16);

		MatOfPoint matPt = new MatOfPoint();
		matPt.fromArray(pt);

		List<MatOfPoint> ppt = new ArrayList<MatOfPoint>();
		ppt.add(matPt);

		Imgproc.fillPoly(img, ppt, new Scalar(255, 255, 255), 8, 0, new Point(0, 0));
	}

	@SuppressWarnings("unused")
	private void MyLine(Mat img, Point start, Point end) {
		Imgproc.line(img, start, end, new Scalar(0, 0, 0), 2, 8, 0);
	}
}

public class BasicGeometricDrawing {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		new GeometricDrawingRun().run();
	}
}
