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

import cn.hippo4j.common.web.exception.IllegalException;
import org.junit.Assert;
import org.junit.Test;

public class NettyProxyCenterTest {

    @Test
    public void getProxy() {
        ProxyInterface localhost = NettyProxyCenter.getProxy(ProxyInterface.class, "localhost", 8888);
        Assert.assertNotNull(localhost);
    }

    @Test(expected = IllegalException.class)
    public void getProxyTest() {
        ProxyClass localhost = NettyProxyCenter.getProxy(ProxyClass.class, "localhost", 8888);
        Assert.assertNotNull(localhost);
    }
    interface ProxyInterface {

    }

    static class ProxyClass {

    }
}