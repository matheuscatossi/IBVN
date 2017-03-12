package com.project.impacta.ibvn.helper;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import java.io.Serializable;

/**
 * Created by proje on 11/03/2017.
 */

public class GPlus implements Serializable {

    private final String email;
    private final String accountName;
    private final String accountType;
    private final String familyName;
    private final String givenName;
    private final String id;
    private String photoUrl;
    private String displaName;

    public GPlus(GoogleSignInAccount gsa) {
        displaName = gsa.getDisplayName();
        photoUrl = gsa.getPhotoUrl().toString();
        email = gsa.getEmail();
        accountName = gsa.getAccount().name;
        accountType = gsa.getAccount().type;
        familyName = gsa.getFamilyName();
        givenName = gsa.getGivenName();
        id = gsa.getId();
    }

    public String getEmail() {
        return email;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDisplaName() {
        return displaName;
    }

    public void setDisplaName(String displaName) {
        this.displaName = displaName;
    }
}
