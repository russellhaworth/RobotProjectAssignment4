package main;

import java.awt.List;
import java.util.ArrayList;

public class GameField {
	int boardLength = 142;
	int boardWidth = 114;
	ArrayList<Node> visitedNodes = new ArrayList<Node>();
	ArrayList<Node> nodesToVisit = new ArrayList<Node>();
	
	GameField(){
		Node[][] gameField = new Node[boardLength][boardWidth];
		for(int i = 0; i < boardLength; i++) {
			for(int j = 0; j < boardWidth; j++) {
				gameField[i][j].x = i;
				gameField[i][j].y = j;
				gameField[i][j].obstacle = false;
			}
		}
	}
	
	public ArrayList<Node> BFS(Node startNode, Node endNode){
		//nodesToVisit.add(startNode);
		
		
		return nodesToVisit;
		
	}
	
	

}
