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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David Navarre <David.Navarre at irit.fr>
 */
public class ActionSimpleTest {

    private static final String CORRECT_NAME = "TOTO";

    public ActionSimpleTest() {
    }

    @Test
    public void testBuildActionSimpleGetNameIsSame() {
        final ActionSimple action = new ActionSimple(CORRECT_NAME);
        final String result = action.getNom();

        Assertions.assertEquals(CORRECT_NAME, result,
                "The nom should be the same as the one used to build the object");
    }

    @Test
    public void testRegisterCoursGetValueIsSame() {
        final ActionSimple action = new ActionSimple(CORRECT_NAME);
        final Jour jour = new Jour(1);
        final float value = 1.0F;
        action.enrgCours(jour, value);

        final float result = action.valeur(jour);

        Assertions.assertEquals(value, result,
                "The cours should be the same as the one registered");
    }

}
