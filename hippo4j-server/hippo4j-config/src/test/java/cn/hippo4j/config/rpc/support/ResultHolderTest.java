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

import cn.hippo4j.common.toolkit.IdUtil;
import org.junit.Assert;
import org.junit.Test;

public class ResultHolderTest {

    @Test
    public void test() {
        String s1 = IdUtil.simpleUUID();
        String o1 = s1 + "1";
        String s2 = IdUtil.simpleUUID();
        String o2 = s2 + "2";

        ResultHolder.put(s1, o1);
        ResultHolder.put(s2, o2);

        Object r1 = ResultHolder.get(s1);
        Object r2 = ResultHolder.get(s2);

        Assert.assertEquals(r1, o1);
        Assert.assertEquals(r2, o2);
    }
}