package com.example.andriatae.mydota2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 *   Created by Andria TAE on 18/03/2018.
 */

public class Match_Data extends RealmObject {


    //foreign Key


        @PrimaryKey
        @SerializedName("match_id")
        @Expose
        private long matchId;
        @SerializedName("player_slot")
        @Expose
        private Integer playerSlot;
        @SerializedName("radiant_win")
        @Expose
        private Boolean radiantWin;
        @SerializedName("duration")
        @Expose
        private Integer duration;
        @SerializedName("game_mode")
        @Expose
        private Integer gameMode;
        @SerializedName("lobby_type")
        @Expose
        private Integer lobbyType;
        @SerializedName("hero_id")
        @Expose
        private Integer heroId;
        @SerializedName("start_time")
        @Expose
        private Integer startTime;
        @SerializedName("version")
        @Expose
        private Integer version;
        @SerializedName("kills")
        @Expose
        private Integer kills;
        @SerializedName("deaths")
        @Expose
        private Integer deaths;
        @SerializedName("assists")
        @Expose
        private Integer assists;
        @SerializedName("skill")
        @Expose
        private Integer skill;
        @SerializedName("xp_per_min")
        @Expose
        private Integer xpPerMin;
        @SerializedName("gold_per_min")
        @Expose
        private Integer goldPerMin;
        @SerializedName("hero_damage")
        @Expose
        private Integer heroDamage;
        @SerializedName("tower_damage")
        @Expose
        private Integer towerDamage;
        @SerializedName("hero_healing")
        @Expose
        private Integer heroHealing;
        @SerializedName("last_hits")
        @Expose
        private Integer lastHits;
        @SerializedName("lane")
        @Expose
        private Integer lane;
        @SerializedName("lane_role")
        @Expose
        private String laneRole;
        @SerializedName("is_roaming")
        @Expose
        private Boolean isRoaming;
        @SerializedName("cluster")
        @Expose
        private Integer cluster;
        @SerializedName("leaver_status")
        @Expose
        private Integer leaverStatus;
        @SerializedName("party_size")
        @Expose
        private Integer partySize;
         private int player_id;


        public long getMatchId() {
            return matchId;
        }

        public void setMatchId(Integer matchId) {
            this.matchId = matchId;
        }

        public Integer getPlayerSlot() {
            return playerSlot;
        }

        public void setPlayerSlot(Integer playerSlot) {
            this.playerSlot = playerSlot;
        }

        public Boolean getRadiantWin() {
            return radiantWin;
        }

        public void setRadiantWin(Boolean radiantWin) {
            this.radiantWin = radiantWin;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public Integer getGameMode() {
            return gameMode;
        }

        public void setGameMode(Integer gameMode) {
            this.gameMode = gameMode;
        }

        public Integer getLobbyType() {
            return lobbyType;
        }

        public void setLobbyType(Integer lobbyType) {
            this.lobbyType = lobbyType;
        }

        public Integer getHeroId() {
            return heroId;
        }

        public void setHeroId(Integer heroId) {
            this.heroId = heroId;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Object getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }

        public Integer getKills() {
            return kills;
        }

        public void setKills(Integer kills) {
            this.kills = kills;
        }

        public Integer getDeaths() {
            return deaths;
        }

        public void setDeaths(Integer deaths) {
            this.deaths = deaths;
        }

        public Integer getAssists() {
            return assists;
        }

        public void setAssists(Integer assists) {
            this.assists = assists;
        }

        public Integer getSkill() {
            return skill;
        }

        public void setSkill(Integer skill) {
            this.skill = skill;
        }

        public Integer getXpPerMin() {
            return xpPerMin;
        }

        public void setXpPerMin(Integer xpPerMin) {
            this.xpPerMin = xpPerMin;
        }

        public Integer getGoldPerMin() {
            return goldPerMin;
        }

        public void setGoldPerMin(Integer goldPerMin) {
            this.goldPerMin = goldPerMin;
        }

        public Integer getHeroDamage() {
            return heroDamage;
        }

        public void setHeroDamage(Integer heroDamage) {
            this.heroDamage = heroDamage;
        }

        public Integer getTowerDamage() {
            return towerDamage;
        }

        public void setTowerDamage(Integer towerDamage) {
            this.towerDamage = towerDamage;
        }

        public Integer getHeroHealing() {
            return heroHealing;
        }

        public void setHeroHealing(Integer heroHealing) {
            this.heroHealing = heroHealing;
        }

        public Integer getLastHits() {
            return lastHits;
        }

        public void setLastHits(Integer lastHits) {
            this.lastHits = lastHits;
        }

        public Object getLane() {
            return lane;
        }

        public void setLane(Integer lane) {
            this.lane = lane;
        }

        public Object getLaneRole() {
            return laneRole;
        }

        public void setLaneRole(String laneRole) {
            this.laneRole = laneRole;
        }

        public Object getIsRoaming() {
            return isRoaming;
        }

        public void setIsRoaming(Boolean isRoaming) {
            this.isRoaming = isRoaming;
        }

        public Integer getCluster() {
            return cluster;
        }

        public void setCluster(Integer cluster) {
            this.cluster = cluster;
        }

        public Integer getLeaverStatus() {
            return leaverStatus;
        }

        public void setLeaverStatus(Integer leaverStatus) {
            this.leaverStatus = leaverStatus;
        }

        public Object getPartySize() {
            return partySize;
        }

        public void setPartySize(Integer partySize) {
            this.partySize = partySize;
        }


    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("matchId", matchId).append("playerSlot", playerSlot).append("radiantWin", radiantWin).append("duration", duration).append("gameMode", gameMode).append("lobbyType", lobbyType).append("heroId", heroId).append("startTime", startTime).append("version", version).append("kills", kills).append("deaths", deaths).append("assists", assists).append("skill", skill).append("xpPerMin", xpPerMin).append("goldPerMin", goldPerMin).append("heroDamage", heroDamage).append("towerDamage", towerDamage).append("heroHealing", heroHealing).append("lastHits", lastHits).append("lane", lane).append("laneRole", laneRole).append("isRoaming", isRoaming).append("cluster", cluster).append("leaverStatus", leaverStatus).append("partySize", partySize).toString();
        }

    }

