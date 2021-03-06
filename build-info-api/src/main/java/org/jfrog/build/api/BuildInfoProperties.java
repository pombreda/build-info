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
package org.jfrog.build.api;

/**
 * @author Tomer Cohen
 */
public interface BuildInfoProperties {

    /**
     * A prefix for all properties that should affect the build info model
     */
    String BUILD_INFO_PREFIX = "buildInfo.";

    /**
     * Prefix for properties that are dynamically added to build info
     */
    String BUILD_INFO_PROP_PREFIX = "buildInfo.property.";

    /**
     * Prefix for build info properties that are coming from the CI server.
     */
    String BUILD_INFO_ENVIRONMENT_PREFIX = "env.";

    //TODO: [by YS] move the build.name etc. to another interface/class and use them from all places
    String PROP_BUILD_NAME = "build.name";
    String PROP_BUILD_NUMBER = "build.number";
    String PROP_PARENT_BUILD_NAME = "build.parentName";
    String PROP_PARENT_BUILD_NUMBER = "build.parentNumber";
    String PROP_VCS_REVISION = "vcs.revision";

    /**
     * Property to link the build back to the CI server that produced the build
     */
    String PROP_BUILD_URL = BUILD_INFO_PREFIX + "buildUrl";
    String PROP_BUILD_AGENT = BUILD_INFO_PREFIX + "buildAgent"; //maven, gradle...
    String PROP_AGENT = BUILD_INFO_PREFIX + "agent"; //hudson, teamcity...
}