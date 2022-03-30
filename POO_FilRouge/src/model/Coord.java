package model;



/**
 * @author francoiseperrin
 *
 * Coordonnées des PieceModel
 */
public class Coord implements Comparable<Coord>{
	
	private char colonne; 	// ['a'..'j']
	private int ligne;		// [10..1]
	static final int MAX = ModelConfig.LENGTH;	// 10

	public Coord(char colonne, int ligne) {
		super();
		this.colonne = colonne;
		this.ligne = ligne;
	}

	public char getColonne() {
		return colonne;
	}

	public int getLigne() {
		return ligne;
	}


	@Override
	public String toString() {
		return "["+ligne + "," + colonne + "]";
	}


	/**
	 * @param coord
	 * @return true si 'a' <= col < 'a'+MAX et 1 < lig <= MAX
	 */
	public static boolean coordonnees_valides(Coord coord){

		// TODO Atelier 1
		return ( 'a'           <= coord.colonne
		 && coord.colonne <  'a' + MAX
		 && 1             <= coord.ligne
		 && coord.ligne   < MAX);
		
	}

	
	//
	@Override
	public boolean equals(Object o)
	{
		//Si notre objet o est déjà notre object actuel pas besoin de comparer, c'est true
		if (o == this)
			return true;
		
		
		//Si jamais Object o n'est pas un Coord, on retourne false
		if (!(o instanceof Coord)) {
            return false;
        }
         
        // On cast donc o en Coord pour les comparer
        Coord c = (Coord) o;
         
        // Enfin, on compare les valeurs
        return c.colonne == this.colonne
        	&& c.ligne   == this.ligne;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * La méthode compareTo() indique comment comparer un objet à l'objet courant
	 * selon l'ordre dit naturel
	 * Dans cet application, nous décidons que l'ordre naturel est celui 
	 * correspondant au N° de la case d'un tableau 2D représenté par la Coord
	 * ainsi le N° 1 correspond à la Coord ['a', 10], le N° 100 correspond à la Coord ['j', 1]  
	 */
	@Override
	public int compareTo(Coord o) {		
		if(o.colonne < this.colonne)
			return 1;
		
		if(o.colonne > this.colonne)
			return -1;
		
		return o.ligne - this.ligne;
	}

}
