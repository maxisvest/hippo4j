/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.hippo4j.config.rpc.support;

import cn.hippo4j.common.toolkit.ReflectUtil;
import cn.hippo4j.common.web.exception.IllegalException;

/**
 * Simply creating an instance of a class by its name and its specific type,
 * and then throwing an exception if it is an interface, is not elegant
 */
public class DefaultInstance implements Instance {

    @Override
    public Object getInstance(Class<?> cls) {
        return ReflectUtil.createInstance(cls);
    }

    @Override
    public Object getInstance(String name) {
        try {
            Class<?> cls = Class.forName(name);
            return getInstance(cls);
        } catch (ClassNotFoundException e) {
            throw new IllegalException(e);
        }
    }
}
