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

package org.apache.sling.graphql.core.mocks;

import java.net.URL;
import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.sling.graphql.api.SlingDataFetcher;
import org.apache.sling.graphql.api.SlingDataFetcherEnvironment;

public class AddressDataFetcher implements SlingDataFetcher<Object> {

    @Override
    public Object get(SlingDataFetcherEnvironment e) throws Exception {
        final Object p = e.getArgument("url");
        if(p instanceof URL) {
            final URL url = (URL)p;
            final Dictionary<String, Object> result = new Hashtable<>();
            result.put("url", url);
            result.put("hostname", url.getHost());
            return result;
        }
        return null;
    }
}
