package com.example.andriatae.mydota2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andria TAE on 13/03/2018.
 */

public class Player_Container extends RealmObject {

    @PrimaryKey
    private int profileid;

    @SerializedName("tracked_until")
    @Expose
    private String trackedUntil;
    @SerializedName("solo_competitive_rank")
    @Expose
    private String soloCompetitiveRank;

    @SerializedName("competitive_rank")
    @Expose
    private String competitiveRank;

    @SerializedName("rank_tier")
    @Expose
    private Integer rankTier;
    @SerializedName("leaderboard_rank")
    @Expose
    private Integer leaderboardRank;

    @SerializedName("mmr_estimate")
    @Expose
    private MMRestimate mmrEstimate;

    @SerializedName("profile")
    @Expose
    private Player player;

    public String getTrackedUntil() {
        return trackedUntil;
    }

    public void setTrackedUntil(String trackedUntil) {
        this.trackedUntil = trackedUntil;
    }

    public String getSoloCompetitiveRank() {
        return soloCompetitiveRank;
    }

    public void setSoloCompetitiveRank(String soloCompetitiveRank) {
        this.soloCompetitiveRank = soloCompetitiveRank;
    }

    public String getCompetitiveRank() {
        return competitiveRank;
    }

    public void setCompetitiveRank(String competitiveRank) {
        this.competitiveRank = competitiveRank;
    }

    public Integer getRankTier() {
        return rankTier;
    }

    public void setRankTier(Integer rankTier) {
        this.rankTier = rankTier;
    }

    public Integer getLeaderboardRank() {
        return leaderboardRank;
    }

    public void setLeaderboardRank(Integer leaderboardRank) {
        this.leaderboardRank = leaderboardRank;
    }

    public MMRestimate getMmrEstimate() {
        return mmrEstimate;
    }

    public void setMmrEstimate(MMRestimate mmrEstimate) {
        this.mmrEstimate = mmrEstimate;
    }

    public Player getProfile() {

        return player;
    }

    public void setProfile(Player player){
        this.player = player;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("trackedUntil", trackedUntil).append("soloCompetitiveRank", soloCompetitiveRank).append("competitiveRank", competitiveRank).append("rankTier", rankTier).append("leaderboardRank", leaderboardRank).append("mmrEstimate", mmrEstimate).append("profile", player).toString();
    }

    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }
}
