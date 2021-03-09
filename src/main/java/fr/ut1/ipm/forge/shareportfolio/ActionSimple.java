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

import java.util.HashMap;

/**
 * This class is the default implementation of the class Action. les actions
 * simples sont des actions ! heritage --> donc <ol><li>concretiser la methode
 * abstraire 'valeur'<li>def d'un constructeur cohérent avec le constructeur
 * parent</ol>
 */
public final class ActionSimple extends Action {

    /**
     * Table de hachage contenant les cours indexés par des jours
     */
    private final HashMap<Jour, Cours> tblCours;

    /**
     * Constructeur cohérent avec le constructeur parent.
     *
     * @param aNom ze nom
     */
    public ActionSimple(final String aNom) {
        super(aNom); // c'est d'abord 1 action !
        this.tblCours = new HashMap<>();
    }

    /**
     * Enregistrement du cours pour un jour donné.
     *
     * @param aJour le jour
     * @param aPrix le prix
     */
    public void enrgCours(final Jour aJour, final float aPrix) {
        /* création d'un objet Cours associé au prix
         *    puis ajout dans la table en indexant par le jour
         */
        this.tblCours.put(aJour, new Cours(aPrix));

    }

    @Override
    public float valeur(final Jour aJour) {
        return tblCours.getOrDefault(aJour, Cours.getDefault()).getValeur();
    }

    /**
     * Classe privée !! La classe n'est accessible que depuis la classe
     * englobante.
     */
    private static class Cours {

        /**
         * A default value for any cours instance.
         */
        private static final Cours DEFAULT_COURS = new Cours(0.0F);
        /**
         * Stores the price.
         */
        private float valeur;

        /**
         * Provides a singleton instance for the class Cours.
         *
         * @return the default instance of class Cours
         */
        public static final Cours getDefault() {
            return DEFAULT_COURS;
        }

        /**
         * Get the value of valeur
         *
         * @return the value of valeur
         */
        public float getValeur() {
            return valeur;
        }

        /**
         * Build one instance of class Cours from a value.
         *
         * @param aValeur the value
         */
        Cours(final float aValeur) {
            this.valeur = aValeur;
        }
    }

}
