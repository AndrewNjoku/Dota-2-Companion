package com.example.andriatae.mydota2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andria TAE on 22/03/2018.
 */

public class Pro_Player extends RealmObject {

        @PrimaryKey
        @SerializedName("account_id")
        @Expose
        private Integer accountId;
        @SerializedName("steamid")
        @Expose
        private Integer steamid;
        @SerializedName("avatar")
        @Expose
        private String avatar;
        @SerializedName("avatarmedium")
        @Expose
        private String avatarmedium;
        @SerializedName("avatarfull")
        @Expose
        private String avatarfull;
        @SerializedName("profileurl")
        @Expose
        private String profileurl;
        @SerializedName("personaname")
        @Expose
        private String personaname;
        @SerializedName("last_login")
        @Expose
        private String lastLogin;
        @SerializedName("full_history_time")
        @Expose
        private String fullHistoryTime;
        @SerializedName("cheese")
        @Expose
        private String cheese;
        @SerializedName("fh_unavailable")
        @Expose
        private String fhUnavailable;
        @SerializedName("loccountrycode")
        @Expose
        private String loccountrycode;
        @SerializedName("last_match_time")
        @Expose
        private String lastMatchTime;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("fantasy_role")
        @Expose
        private Integer fantasyRole;
        @SerializedName("team_id")
        @Expose
        private Integer teamId;
        @SerializedName("team_name")
        @Expose
        private String teamName;
        @SerializedName("team_tag")
        @Expose
        private String teamTag;
        @SerializedName("is_locked")
        @Expose
        private Boolean isLocked;
        @SerializedName("is_pro")
        @Expose
        private Boolean isPro;
        @SerializedName("locked_until")
        @Expose
        private Integer lockedUntil;

        public Integer getAccountId() {
            return accountId;
        }

        public void setAccountId(Integer accountId) {
            this.accountId = accountId;
        }

        public Object getSteamid() {
            return steamid;
        }

        public void setSteamid(Integer steamid) {
            this.steamid = steamid;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Object getAvatarmedium() {
            return avatarmedium;
        }

        public void setAvatarmedium(String avatarmedium) {
            this.avatarmedium = avatarmedium;
        }

        public Object getAvatarfull() {
            return avatarfull;
        }

        public void setAvatarfull(String avatarfull) {
            this.avatarfull = avatarfull;
        }

        public Object getProfileurl() {
            return profileurl;
        }

        public void setProfileurl(String profileurl) {
            this.profileurl = profileurl;
        }

        public Object getPersonaname() {
            return personaname;
        }

        public void setPersonaname(String personaname) {
            this.personaname = personaname;
        }

        public Object getLastLogin() {
            return lastLogin;
        }

        public void setLastLogin(String lastLogin) {
            this.lastLogin = lastLogin;
        }

        public Object getFullHistoryTime() {
            return fullHistoryTime;
        }



        public Object getCheese() {
            return cheese;
        }



        public Object getFhUnavailable() {
            return fhUnavailable;
        }



        public Object getLoccountrycode() {
            return loccountrycode;
        }



        public Object getLastMatchTime() {
            return lastMatchTime;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Integer getFantasyRole() {
            return fantasyRole;
        }

        public void setFantasyRole(Integer fantasyRole) {
            this.fantasyRole = fantasyRole;
        }

        public Integer getTeamId() {
            return teamId;
        }

        public void setTeamId(Integer teamId) {
            this.teamId = teamId;
        }

        public Object getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Object getTeamTag() {
            return teamTag;
        }

        public void setTeamTag(String teamTag) {
            this.teamTag = teamTag;
        }

        public Boolean getIsLocked() {
            return isLocked;
        }

        public void setIsLocked(Boolean isLocked) {
            this.isLocked = isLocked;
        }

        public Boolean getIsPro() {
            return isPro;
        }

        public void setIsPro(Boolean isPro) {
            this.isPro = isPro;
        }

        public Integer getLockedUntil() {
            return lockedUntil;
        }

        public void setLockedUntil(Integer lockedUntil) {
            this.lockedUntil = lockedUntil;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("accountId", accountId).append("steamid", steamid).append("avatar", avatar).append("avatarmedium", avatarmedium).append("avatarfull", avatarfull).append("profileurl", profileurl).append("personaname", personaname).append("lastLogin", lastLogin).append("fullHistoryTime", fullHistoryTime).append("cheese", cheese).append("fhUnavailable", fhUnavailable).append("loccountrycode", loccountrycode).append("lastMatchTime", lastMatchTime).append("name", name).append("countryCode", countryCode).append("fantasyRole", fantasyRole).append("teamId", teamId).append("teamName", teamName).append("teamTag", teamTag).append("isLocked", isLocked).append("isPro", isPro).append("lockedUntil", lockedUntil).toString();
        }

    }
