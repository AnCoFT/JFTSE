package com.jftse.emulator.server.game.core.matchplay.room;

import com.jftse.emulator.server.game.core.matchplay.MatchplayGame;
import com.jftse.emulator.server.shared.module.Client;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class GameSession {
    public GameSession() {
        clients = new ArrayList<>();
        clientsInRelay = new ArrayList<>();
        playerLocationsOnMap = Arrays.asList(
                new Point(20, -125),
                new Point(-20, 125),
                new Point(-20, -75),
                new Point(20, 75)
        );
    }

    private int sessionId;
    private MatchplayGame activeMatchplayGame;
    private byte players;

    private List<Point> playerLocationsOnMap;
    private int lastBallHitByPlayer = -1;
    private long timeLastBallWasHit = -1;
    private int timesCourtChanged = 0;
    private List<Client> clients; // holds everything from game server
    private List<Client> clientsInRelay;

    public Client getClientByPlayerId(long playerId) {
        return clients.stream()
                .filter(c -> c.getActivePlayer().getId().equals(playerId))
                .findFirst()
                .orElse(null);
    }
}