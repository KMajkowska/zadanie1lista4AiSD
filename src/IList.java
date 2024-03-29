public interface IList<Integer>
{
	
	// FUNKCJONALNOŚĆ PODSTAWOWA
	 boolean add(Integer e); 
	 // dodanie elementu na koniec listy
	 void add(int index, Integer element); 
	 // dodanie elementu na podanej pozycji
	 void clear(); 
	 // skasowanie wszystkich elementów
	 boolean contains(Integer element); 
	 // czy lista zawiera podany element (equals())
	 Integer get(int index); 
	 // pobranie elementu z podanej pozycji
	 Integer set(int index, Integer element); 
	 // ustawienie nowej wartości na pozycji
	 int indexOf(Integer element); 
	 // pozycja szukanego elementu (equals())
	 boolean isEmpty(); 
	 // czy lista jest pusta
	 // zwraca iterator przed pierwszą pozycją
	 Integer remove(int index); 
	 // usuwa element z podanej pozycji
	 boolean remove(Element e); 
	 // usuwa element (equals())
	 int size(); // rozmiar listy
}
	 
