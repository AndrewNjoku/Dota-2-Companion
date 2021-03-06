package com.example.andriatae.mydota2.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Hero_Stats extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("localized_name")
    @Expose
    private String localizedName;
    @SerializedName("primary_attr")
    @Expose
    private String primaryAttr;
    @SerializedName("attack_type")
    @Expose
    private String attackType;
    @SerializedName("roles")
    @Expose
    private RealmList<String> roles = null;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("base_health")
    @Expose
    private Integer baseHealth;
    @SerializedName("base_health_regen")
    @Expose
    private Double baseHealthRegen;
    @SerializedName("base_mana")
    @Expose
    private Integer baseMana;
    @SerializedName("base_mana_regen")
    @Expose
    private Double baseManaRegen;
    @SerializedName("base_armor")
    @Expose
    private Double baseArmor;
    @SerializedName("base_mr")
    @Expose
    private Integer baseMr;
    @SerializedName("base_attack_min")
    @Expose
    private Integer baseAttackMin;
    @SerializedName("base_attack_max")
    @Expose
    private Integer baseAttackMax;
    @SerializedName("base_str")
    @Expose
    private Integer baseStr;
    @SerializedName("base_agi")
    @Expose
    private Integer baseAgi;
    @SerializedName("base_int")
    @Expose
    private Integer baseInt;
    @SerializedName("str_gain")
    @Expose
    private Double strGain;
    @SerializedName("agi_gain")
    @Expose
    private Double agiGain;
    @SerializedName("int_gain")
    @Expose
    private Double intGain;
    @SerializedName("attack_range")
    @Expose
    private Integer attackRange;
    @SerializedName("projectile_speed")
    @Expose
    private Integer projectileSpeed;
    @SerializedName("attack_rate")
    @Expose
    private Double attackRate;
    @SerializedName("move_speed")
    @Expose
    private Integer moveSpeed;
    @SerializedName("turn_rate")
    @Expose
    private Double turnRate;
    @SerializedName("cm_enabled")
    @Expose
    private Boolean cmEnabled;
    @SerializedName("legs")
    @Expose
    private Integer legs;
    @SerializedName("pro_ban")
    @Expose
    private Integer proBan;
    @SerializedName("hero_id")
    @Expose
    private Integer heroId;
    @SerializedName("pro_win")
    @Expose
    private Integer proWin;
    @SerializedName("pro_pick")
    @Expose
    private Integer proPick;
    @SerializedName("1_pick")
    @Expose
    private Integer _1Pick;
    @SerializedName("1_win")
    @Expose
    private Integer _1Win;
    @SerializedName("7_pick")
    @Expose
    private Integer _7Pick;
    @SerializedName("7_win")
    @Expose
    private Integer _7Win;
    @SerializedName("6_pick")
    @Expose
    private Integer _6Pick;
    @SerializedName("6_win")
    @Expose
    private Integer _6Win;
    @SerializedName("4_pick")
    @Expose
    private Integer _4Pick;
    @SerializedName("4_win")
    @Expose
    private Integer _4Win;
    @SerializedName("2_pick")
    @Expose
    private Integer _2Pick;
    @SerializedName("2_win")
    @Expose
    private Integer _2Win;
    @SerializedName("5_pick")
    @Expose
    private Integer _5Pick;
    @SerializedName("5_win")
    @Expose
    private Integer _5Win;
    @SerializedName("3_pick")
    @Expose
    private Integer _3Pick;
    @SerializedName("3_win")
    @Expose
    private Integer _3Win;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(RealmList<String> roles) {
        this.roles = roles;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(Integer baseHealth) {
        this.baseHealth = baseHealth;
    }

    public Double getBaseHealthRegen() {
        return baseHealthRegen;
    }

    public void setBaseHealthRegen(Double baseHealthRegen) {
        this.baseHealthRegen = baseHealthRegen;
    }

    public Integer getBaseMana() {
        return baseMana;
    }

    public void setBaseMana(Integer baseMana) {
        this.baseMana = baseMana;
    }

    public Double getBaseManaRegen() {
        return baseManaRegen;
    }

    public void setBaseManaRegen(Double baseManaRegen) {
        this.baseManaRegen = baseManaRegen;
    }

    public Double getBaseArmor() {
        return baseArmor;
    }

    public void setBaseArmor(Double baseArmor) {
        this.baseArmor = baseArmor;
    }

    public Integer getBaseMr() {
        return baseMr;
    }

    public void setBaseMr(Integer baseMr) {
        this.baseMr = baseMr;
    }

    public Integer getBaseAttackMin() {
        return baseAttackMin;
    }

    public void setBaseAttackMin(Integer baseAttackMin) {
        this.baseAttackMin = baseAttackMin;
    }

    public Integer getBaseAttackMax() {
        return baseAttackMax;
    }

    public void setBaseAttackMax(Integer baseAttackMax) {
        this.baseAttackMax = baseAttackMax;
    }

    public Integer getBaseStr() {
        return baseStr;
    }

    public void setBaseStr(Integer baseStr) {
        this.baseStr = baseStr;
    }

    public Integer getBaseAgi() {
        return baseAgi;
    }

    public void setBaseAgi(Integer baseAgi) {
        this.baseAgi = baseAgi;
    }

    public Integer getBaseInt() {
        return baseInt;
    }

    public void setBaseInt(Integer baseInt) {
        this.baseInt = baseInt;
    }

    public Double getStrGain() {
        return strGain;
    }

    public void setStrGain(Double strGain) {
        this.strGain = strGain;
    }

    public Double getAgiGain() {
        return agiGain;
    }

    public void setAgiGain(Double agiGain) {
        this.agiGain = agiGain;
    }

    public Double getIntGain() {
        return intGain;
    }

    public void setIntGain(Double intGain) {
        this.intGain = intGain;
    }

    public Integer getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(Integer attackRange) {
        this.attackRange = attackRange;
    }

    public Integer getProjectileSpeed() {
        return projectileSpeed;
    }

    public void setProjectileSpeed(Integer projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }

    public Double getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(Double attackRate) {
        this.attackRate = attackRate;
    }

    public Integer getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Integer moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Double getTurnRate() {
        return turnRate;
    }

    public void setTurnRate(Double turnRate) {
        this.turnRate = turnRate;
    }

    public Boolean getCmEnabled() {
        return cmEnabled;
    }

    public void setCmEnabled(Boolean cmEnabled) {
        this.cmEnabled = cmEnabled;
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public Integer getProBan() {
        return proBan;
    }

    public void setProBan(Integer proBan) {
        this.proBan = proBan;
    }

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public Integer getProWin() {
        return proWin;
    }

    public void setProWin(Integer proWin) {
        this.proWin = proWin;
    }

    public Integer getProPick() {
        return proPick;
    }

    public void setProPick(Integer proPick) {
        this.proPick = proPick;
    }

    public Integer get1Pick() {
        return _1Pick;
    }

    public void set1Pick(Integer _1Pick) {
        this._1Pick = _1Pick;
    }

    public Integer get1Win() {
        return _1Win;
    }

    public void set1Win(Integer _1Win) {
        this._1Win = _1Win;
    }

    public Integer get7Pick() {
        return _7Pick;
    }

    public void set7Pick(Integer _7Pick) {
        this._7Pick = _7Pick;
    }

    public Integer get7Win() {
        return _7Win;
    }

    public void set7Win(Integer _7Win) {
        this._7Win = _7Win;
    }

    public Integer get6Pick() {
        return _6Pick;
    }

    public void set6Pick(Integer _6Pick) {
        this._6Pick = _6Pick;
    }

    public Integer get6Win() {
        return _6Win;
    }

    public void set6Win(Integer _6Win) {
        this._6Win = _6Win;
    }

    public Integer get4Pick() {
        return _4Pick;
    }

    public void set4Pick(Integer _4Pick) {
        this._4Pick = _4Pick;
    }

    public Integer get4Win() {
        return _4Win;
    }

    public void set4Win(Integer _4Win) {
        this._4Win = _4Win;
    }

    public Integer get2Pick() {
        return _2Pick;
    }

    public void set2Pick(Integer _2Pick) {
        this._2Pick = _2Pick;
    }

    public Integer get2Win() {
        return _2Win;
    }

    public void set2Win(Integer _2Win) {
        this._2Win = _2Win;
    }

    public Integer get5Pick() {
        return _5Pick;
    }

    public void set5Pick(Integer _5Pick) {
        this._5Pick = _5Pick;
    }

    public Integer get5Win() {
        return _5Win;
    }

    public void set5Win(Integer _5Win) {
        this._5Win = _5Win;
    }

    public Integer get3Pick() {
        return _3Pick;
    }

    public void set3Pick(Integer _3Pick) {
        this._3Pick = _3Pick;
    }

    public Integer get3Win() {
        return _3Win;
    }

    public void set3Win(Integer _3Win) {
        this._3Win = _3Win;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("localizedName", localizedName).append("primaryAttr", primaryAttr).append("attackType", attackType).append("roles", roles).append("img", img).append("icon", icon).append("baseHealth", baseHealth).append("baseHealthRegen", baseHealthRegen).append("baseMana", baseMana).append("baseManaRegen", baseManaRegen).append("baseArmor", baseArmor).append("baseMr", baseMr).append("baseAttackMin", baseAttackMin).append("baseAttackMax", baseAttackMax).append("baseStr", baseStr).append("baseAgi", baseAgi).append("baseInt", baseInt).append("strGain", strGain).append("agiGain", agiGain).append("intGain", intGain).append("attackRange", attackRange).append("projectileSpeed", projectileSpeed).append("attackRate", attackRate).append("moveSpeed", moveSpeed).append("turnRate", turnRate).append("cmEnabled", cmEnabled).append("legs", legs).append("proBan", proBan).append("heroId", heroId).append("proWin", proWin).append("proPick", proPick).append("_1Pick", _1Pick).append("_1Win", _1Win).append("_7Pick", _7Pick).append("_7Win", _7Win).append("_6Pick", _6Pick).append("_6Win", _6Win).append("_4Pick", _4Pick).append("_4Win", _4Win).append("_2Pick", _2Pick).append("_2Win", _2Win).append("_5Pick", _5Pick).append("_5Win", _5Win).append("_3Pick", _3Pick).append("_3Win", _3Win).toString();
    }

}
