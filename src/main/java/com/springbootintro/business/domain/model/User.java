package com.springbootintro.business.domain.model;

import com.springbootintro.helper.EmailNotFoundException;
import com.springbootintro.helper.IdNotFoundException;

/**
 * Created by maksym_govorischev on 14/03/14.
 */
public interface User {
    /**
     * User Id. UNIQUE.
     * @return User Id.
     */
    long getId();
    void setId(long id) throws IdNotFoundException;
    String getName();
    void setName(String name);

    /**
     * User email. UNIQUE.
     * @return User email.
     */
    String getEmail();
    void setEmail(String email) throws EmailNotFoundException;
}
