
public class RectangleArea {
	//Find the total area covered by two rectilinear rectangles in a 2D plane. 
	//Each rectangle is defined by its bottom left corner and top right corner coordinates.
	public static void main(String[] args) {
		// think about one scenario only: bottom-left rectangle and top-right rectangle
		// other scenarios can be retrieved by shifting
		System.out.println(computeArea(1,-1,5,2,3,0,6,5));
		
	}

	private static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		// no overlapping area
		if(C<E || G<A)
			return (C-A)*(D-B)+(G-E)*(H-F);
		if(D<F || H<B)
			return (D-B)*(C-A)+(H-F)*(G-E);
		
		//overlapping area
		int right=Math.min(C, G);
		int left=Math.max(A, E);
		int top=Math.min(D, H);
		int bottom=Math.max(B, F);
		
		return (C-A)*(D-B)+(G-E)*(H-F)-(right-left)*(top-bottom);
	}

}
