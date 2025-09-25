package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class InfyCupCricketSelection {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfPlayers = 3;

		List<Player> playersList = new ArrayList<>();
		Player player = new Player("Jack", 40.6, "27/11/1993");
		Player player2 = new Player("Sherlock", 50.7, "28/12/1994");
		Player player3 = new Player("John", 45.8, "29/01/1995");
		playersList.add(player);
		playersList.add(player2);
		playersList.add(player3);

		Map<Integer, Player> finalSetOfPlayers = new HashMap<>();
		finalSetOfPlayers = Player.selectionProcess(playersList, noOfPlayers);
		System.out.println(finalSetOfPlayers);
		scan.close();

	}

}

class Player {
	private String playerName;
	private Double avarage;
	private String playerDOB;

	public Player(String playerName, Double avarage, String playerDOB) {
		super();
		this.playerName = playerName;
		this.avarage = avarage;
		this.playerDOB = playerDOB;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Double getAvarage() {
		return avarage;
	}

	public void setAvarage(Double avarage) {
		this.avarage = avarage;
	}

	public String getPlayerDOB() {
		return playerDOB;
	}

	public void setPlayerDOB(String playerDOB) {
		this.playerDOB = playerDOB;
	}

	@Override
	public String toString() {
		return this.playerName + "";
	}

	public static Map<Integer, Player> selectionProcess(List<Player> playerList, int noOfPlayers) {
		// Write your logic as per the instructions
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		Collections.sort(playerList, (p1, p2) -> {
			int avgCompare = p2.getAvarage().compareTo(p1.getAvarage()); // high to low
			if (avgCompare != 0) {
				return avgCompare;
			}
			try {
				Date date1 = sf.parse(p1.getPlayerDOB());
				Date date2 = sf.parse(p2.getPlayerDOB());
				int dobComapare = date1.compareTo(date2);
				return dobComapare;

			} catch (Exception e) {
				System.out.println("Invalid date Format");
			}
			return p1.getPlayerName().compareTo(p2.getPlayerName());
		});

		Map<Integer, Player> finalList = new HashMap<>();
		for (int i = 0; i < playerList.size(); i++) {
			finalList.put(i + 1, playerList.get(i));
		}

		return finalList;

	}
}