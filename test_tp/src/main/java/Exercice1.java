package main.java;

import java.io.*;
import java.lang.*;
import java.util.*;



/**
 * @author Les méthodes de tri sont issues de : http://pauillac.inria.fr/~levy/x/tc98/java/Tri.java
 *
 */
class Exercice1 {

	static int N = 10;
	static int[] a = new int[N];          // Le tableau à trier

	static void initialisation(String[] args) { 

		N = args.length;
		for (int i = 0; i < N; ++i)
			a[i] = (int) Integer.parseInt(args[i]);
	}

	static void impression() {
		for (int i = 0; i < N; ++i)
			System.out.print (" " + a[i] + " ");
		System.out.println ("");
	}

	static void triSelection() {
		int   min, t;

		for (int i = 0; i < N - 1; ++i) {
			min = i;
			for (int j = i+1; j < N; ++j)
				if (a[j] < a[min])
					min = j; 
			t = a[min]; a[min] = a[i]; a[i] = t;
		}
	}

	static void triBulle() {

		int   t;

		for (int i = N-1; i >= 0; --i) 
			for (int j = 1; j <= i; ++j)
				if (a[j-1] > a[j]) {
					t = a[j-1]; a[j-1] = a[j]; a[j] = t;
				}
	}

	static void triInsertion() {
		int   j, v;

		for (int i = 1; i < N; ++i) {
			v = a[i]; j = i;
			while (j > 0  &&  a[j-1] > v) {
				a[j] = a[j-1]; 
				--j;
			}
			a[j] = v;
		}
	}

	static void triShell() {
		int   h;

		h = 1; do 
			h = 3*h + 1; 
		while ( h <= N );
		do {
			h = h / 3;
			for (int i = h; i < N; ++i)
				if (a[i] < a[i-h]) {
					int   v = a[i], j = i;
					do {
						a[j] = a[j-h];
						j = j - h;
					} while (j >= h  &&  a[j-h] > v);
					a[j] = v;
				}
		} while ( h > 1);
	}

	public static void main(String args[]) {



		initialisation(args);   // On lit le tableau
		impression();       // et on l'imprime
		triSelection();     // On trie
		impression();       // On imprime le résultat
		triBulle();      
		impression();    
		triInsertion();
		triShell();
		impression();    
	}
}