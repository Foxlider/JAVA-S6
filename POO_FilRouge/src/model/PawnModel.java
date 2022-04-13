package model;


import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import nutsAndBolts.PieceSquareColor;

public class PawnModel implements PieceModel{

	private Coord coord;
	private PieceSquareColor pieceColor;

	public PawnModel(Coord coord, PieceSquareColor pieceColor) {
		super();

		this.coord = coord;
		this.pieceColor = pieceColor;

	}

	@Override
	public char getColonne() 
	{
		if(coord == null)
			return ' ';
		
		return coord.getColonne();
	}

	@Override
	public int getLigne() 
	{
		if(coord == null)
			return -1;
		
		return coord.getLigne();
	}

	@Override
	public boolean hasThisCoord(Coord c) 
	{
		return coord.equals(c);
	}

	@Override
	public PieceSquareColor getPieceColor() {
		return pieceColor;	
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String st = null;
		
		var col = pieceColor;
		var colC = (pieceColor == PieceSquareColor.BLACK) ? 'B': 'W';
		var cln =  getColonne();
		var lin = getLigne();
		
		st = String.format("[%c[%d,%c]]", colC, lin, cln);
				
		return st;
	}

	@Override
	public void move(Coord coord) {

		this.coord = coord;
	}

	@Override
	public boolean isMoveOk(Coord targetCoord, boolean isPieceToCapture) {
		var dist = isPieceToCapture ? 2 : 1;
		var colDiff = Math.abs(getColonne() - targetCoord.getColonne());
		var linDiff = Math.abs(getLigne() - targetCoord.getLigne());
		
		return (linDiff == dist && colDiff == dist);
	}

	@Override
	public List<Coord> getCoordsOnItinerary(Coord targetCoord) {

		List<Coord> coordsOnItinery = new LinkedList<Coord>(); 
		
		// TODO Atelier 2
		int posCol = getColonne();
		int posLig = getLigne();
		
		int colDiff = Math.abs(posCol - targetCoord.getColonne());
		int linDiff = Math.abs(posLig - targetCoord.getLigne());
		
		int sigCol = (int) Math.signum(targetCoord.getColonne());
		int sigLig = (int) Math.signum(posLig - targetCoord.getLigne());
		
		
		if (colDiff != linDiff)
			return coordsOnItinery;
		
		for(int i = 1; i < colDiff; i++)
			coordsOnItinery.add(new Coord((char) (posCol + i*sigCol), posLig + i*sigLig));

		return coordsOnItinery;
	}

	
}

