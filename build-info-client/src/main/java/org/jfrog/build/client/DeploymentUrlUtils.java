/*
 * Copyright (C) 2010 JFrog Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jfrog.build.client;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.jfrog.build.api.BuildInfoConfigProperties;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author Tomer C.
 */
public abstract class DeploymentUrlUtils {

    /**
     * Calculate the full Artifactory deployment URL which includes the matrix params appended to it. see {@link
     * org.jfrog.build.api.BuildInfoConfigProperties#BUILD_INFO_DEPLOY_PROP_PREFIX} for the property prefix that this
     * method takes into account.
     *
     * @param artifactoryUrl The Artifactory upload URL.
     * @param properties     The properties to append to the Artifactory URL.
     * @return The generated Artifactory URL with the matrix params appended to it.
     */
    public static String getDeploymentUrl(String artifactoryUrl, Properties properties) {
        Map<Object, Object> filteredProperties = Maps.filterKeys(properties, new Predicate<Object>() {
            public boolean apply(Object input) {
                String inputKey = (String) input;
                return inputKey.startsWith(BuildInfoConfigProperties.BUILD_INFO_DEPLOY_PROP_PREFIX);
            }
        });
        StringBuilder deploymentUrl = new StringBuilder(artifactoryUrl);
        Set<Map.Entry<Object, Object>> propertyEntries = filteredProperties.entrySet();
        for (Map.Entry<Object, Object> propertyEntry : propertyEntries) {
            String key = StringUtils
                    .removeStart((String) propertyEntry.getKey(),
                            BuildInfoConfigProperties.BUILD_INFO_DEPLOY_PROP_PREFIX);
            deploymentUrl.append(";").append(key).append("=").append(propertyEntry.getValue());
        }
        return deploymentUrl.toString();
    }
}