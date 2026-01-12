package models;

import java.time.LocalDateTime;

public class Bid {

    private final int id;
    private final int auctionId;
    private final int buyerId;
    private final double amount;
    private final LocalDateTime time;

    public Bid(double amount, int auctionId, int buyerId, int id, LocalDateTime time) {
        this.amount = amount;
        this.auctionId = auctionId;
        this.buyerId = buyerId;
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTime() {
        return time;
    }

}
