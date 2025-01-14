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

package cn.hippo4j.config.rpc.server;

import cn.hippo4j.config.rpc.support.DefaultInstance;
import cn.hippo4j.config.rpc.support.Instance;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RPCServerTest {

    public static int port = 8888;

    @Test
    public void bind() throws IOException {
        Instance instance = new DefaultInstance();
        ServerConnection connection = new NettyServerConnection(instance);
        RPCServer rpcServer = new RPCServer(port, connection);
        CompletableFuture.runAsync(rpcServer::bind);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rpcServer.close();
    }

    @Test
    public void bindTest() throws IOException {
        Instance instance = new DefaultInstance();
        EventLoopGroup leader = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerConnection connection = new NettyServerConnection(leader, worker, instance);
        RPCServer rpcServer = new RPCServer(port, connection);
        CompletableFuture.runAsync(rpcServer::bind);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        rpcServer.close();
    }

}