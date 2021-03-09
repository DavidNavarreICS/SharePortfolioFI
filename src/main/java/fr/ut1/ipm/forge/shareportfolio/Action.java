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
    public final String getNom() {
        return nom;
    }

    /**
     * Build one instance of class Action from a name.
     *
     * @param aNom the name of the created action
     */
    public Action(final String aNom) {
        if (Objects.isNull(aNom)) {
            throw new IllegalArgumentException("nom cannot be null");
        }
        if (aNom.isEmpty()) {
            throw new IllegalArgumentException("nom cannot be empty");
        }
        this.nom = aNom;
    }

    /**
     * Provides the value of the action for a given day.
     *
     * @param aJour the given day
     * @return the vaule of the action for this day
     */
    public abstract float valeur(final Jour aJour);

    @Override
    public final boolean equals(final Object obj) {
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
    public final int hashCode() {
        return this.getNom().toUpperCase().hashCode();
    }

    @Override
    public String toString() {
        return this.getNom();
    }
}
