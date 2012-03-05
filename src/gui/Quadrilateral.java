package gui;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Quadrilateral is a class for the purpose of drawing a Quadrilateral 
 * with specified points for NewtonsToolboxGui.java
 * 
 *  1 + + + 2
 *  +      +
 * 	+     +
 *  +    +
 *  4 + 3
 * 
 * @author Michelle Len
 * @version 03/04/2012 for CS 48 Project, W12
 */
public class Quadrilateral extends Polygon {

	/**
	 * Private variables
	 */
	
	private int xUL;	private int yUL;
	private int xUR;	private int yUR;
	private int xLR;	private int yLR;
	private int xLL;	private int yLL; 
	
	// Included to suppress Eclipse Warning
	private static final long serialVersionUID = 4501125734040909392L;	
	
	/**
	 * Calls super Constructor
	 */
	public Quadrilateral() {
		super();
	}
	
	/**
	 * Calls super Polygon Constructor
	 * @param xUL X-Coordinate of the UpperLeft Corner
	 * @param yUL Y-Coordinate of the UpperLeft Corner
	 * @param xUR X-Coordinate of the UpperRight Corner
	 * @param yUR Y-Coordinate of the UpperRight Corner
	 * @param xLR X-Coordinate of the LowerRight Corner
	 * @param yLR Y-Coordinate of the LowerRight Corner
	 * @param xLL X-Coordinate of the LowerLeft Corner
	 * @param yLL Y-Coordinate of the LowerLeft Corner
	 */
	public Quadrilateral(int xUL, int yUL, 
						 int xUR, int yUR, 
						 int xLR, int yLR, 
						 int xLL, int yLL) {
		super();
		this.addPoint(xUL, yUL);
		this.addPoint(xUR, yUR);
		this.addPoint(xLR, yLR);
		this.addPoint(xLL, yLL);
	}
	
	/**
	 * Get Methods for obtaining all the eight int values for the points
	 * @return this.xUL, this.yUL, this.xUR, this.yUR, this.xLR, this.yLR, this.xLL, this.yLL
	 */
	public int getXUL() { return this.xUL; }	public int getYUL() { return this.yUL; }
	public int getXUR() { return this.xUR; }	public int getYUR() { return this.yUR; }
	public int getXLR() { return this.xLR; }	public int getYLR() { return this.yLR; }
	public int getXLL() { return this.xLL; }	public int getYLL() { return this.yLL; }
	
	/**
	 * Set Methods for setting the coordinate points
	 */
	public void setXUL(int xUL) { this.xUL = xUL; }	public void setYUL(int yUL) { this.yUL = yUL; }
	public void setXUR(int xUR) { this.xUR = xUR; }	public void setYUR(int yUR) { this.yUR = yUR; }
	public void setXLR(int xLR) { this.xLR = xLR; }	public void setYLR(int yLR) { this.yLR = yLR; }
	public void setXLL(int xLL) { this.xLL = xLL; }	public void setYLL(int yLL) { this.yLL = yLL; }
	
	/**
	 * Method that uses Polygon's draw method to draw the Quadrilateral
	 */
	public void draw(Graphics g) { g.drawPolygon(this); }

	/**
	 * Method that uses Polygon's fill method to fill the Quadrilateral
	 */
	public void fill(Graphics g) { g.fillPolygon(this); }
	
}