/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package fr.ut1.ipm.forge.shareportfolio;

import java.util.Objects;

/**
 * This class provides a super class for all kind of Actions.
 *
 * @author David Navarre &lt;David.Navarre at irit.fr&gt;
 * @see ActionSimple
 * @see ActionCompliquee
 * @since 1.0
 */
public abstract class Action {

    /**
     * The name of the Share.
     */
    private final String nom;

    /**
     * Get the value of nom.
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Build one instance of class Action from a name.
     *
     * @param nom the name of the created action
     */
    public Action(final String nom) {
        if (Objects.isNull(nom)) {
            throw new IllegalArgumentException("nom cannot be null");
        }
        if (nom.isEmpty()) {
            throw new IllegalArgumentException("nom cannot be empty");
        }
        this.nom = nom;
    }

    public abstract float valeur(final Jour j);

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Action other = (Action) obj;
        return (Objects.equals(this.nom, other.nom));
    }

    @Override
    public int hashCode() {
        return this.getNom().toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        return this.getNom();
    }
}
