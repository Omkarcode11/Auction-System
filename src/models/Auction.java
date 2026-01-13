package models;

import enums.AuctionState;
import java.time.LocalDateTime;

public class Auction {
    private final int id;
    private final Item item;
    private final int sellerId;
    private final double sellPrice;
    private final double basePrice;
    private final double minIncrement;
    private final LocalDateTime endTime;

    private AuctionState state;
    private Bid highestBid;

    public Auction(int id, Item item, int sellerId, double sellPrice, double basePrice, double minIncrement,
            LocalDateTime endTime, Bid highestBid) {
        this.id = id;
        this.item = item;
        this.sellerId = sellerId;
        this.sellPrice = sellPrice;
        this.basePrice = basePrice;
        this.minIncrement = minIncrement;
        this.endTime = endTime;
        this.state = AuctionState.CREATED;
        this.highestBid = null;
    }

    public boolean updateHighestBid(Bid bid){
        if(state != AuctionState.CLOSED) return false;

        double currentPrice = (highestBid == null) ? basePrice : highestBid.getAmount();

        if(bid.getAmount() >= currentPrice + minIncrement){
            highestBid = bid;
            return true;
        }

        return false;
    }

    public void activate(){
        this.state = AuctionState.ACTIVE;
    }

    public void close(){
        this.state = AuctionState.CLOSED;


    }
    
    public Bid getHighestBid(){
        return highestBid;
    }
    
}
