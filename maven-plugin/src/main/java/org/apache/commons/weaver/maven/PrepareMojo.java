/*
 *  Copyright the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.weaver.maven;

import java.io.File;
import java.util.List;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Prepare for weaving by deleting classes previously woven with a different policy.
 */
@Mojo(name = "prepare", defaultPhase = LifecyclePhase.INITIALIZE, requiresDependencyCollection = ResolutionScope.COMPILE)
public class PrepareMojo extends AbstractPrepareMojo {
    @Parameter(readonly = true, required = true, defaultValue = "${project.compileClasspathElements}")
    protected List<String> classpath;

    @Parameter(readonly = true, required = true, defaultValue = "${project.build.outputDirectory}")
    protected File target;

    @Override
    protected List<String> getClasspath() {
        return classpath;
    }

    @Override
    protected File getTarget() {
        return target;
    }

}
