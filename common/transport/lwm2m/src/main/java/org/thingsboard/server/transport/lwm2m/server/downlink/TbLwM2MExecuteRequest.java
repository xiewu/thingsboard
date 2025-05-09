/**
 * Copyright © 2016-2025 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server.downlink;

import lombok.Builder;
import lombok.Getter;
import org.eclipse.leshan.core.response.ReadResponse;
import org.thingsboard.server.transport.lwm2m.server.LwM2MOperationType;

public class TbLwM2MExecuteRequest extends AbstractTbLwM2MTargetedDownlinkRequest<ReadResponse> {

    @Getter
    private final Object params;

    @Builder
    private TbLwM2MExecuteRequest(String versionedId, long timeout, Object params) {
        super(versionedId, timeout);
        this.params = params;
    }

    @Override
    public LwM2MOperationType getType() {
        return LwM2MOperationType.EXECUTE;
    }



}
