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
package org.thingsboard.server.edqs.query.processor;

import org.thingsboard.server.common.data.permission.QueryContext;
import org.thingsboard.server.common.data.query.EntityNameFilter;
import org.thingsboard.server.edqs.data.EntityData;
import org.thingsboard.server.edqs.query.EdqsQuery;
import org.thingsboard.server.edqs.repo.TenantRepo;
import org.thingsboard.server.edqs.util.RepositoryUtils;

import java.util.regex.Pattern;

public class EntityNameQueryProcessor extends AbstractSimpleQueryProcessor<EntityNameFilter> {

    private final Pattern pattern;

    public EntityNameQueryProcessor(TenantRepo repo, QueryContext ctx, EdqsQuery query) {
        super(repo, ctx, query, (EntityNameFilter) query.getEntityFilter(), ((EntityNameFilter) query.getEntityFilter()).getEntityType());
        pattern = RepositoryUtils.toEntityNameSqlLikePattern(filter.getEntityNameFilter());
    }

    @Override
    protected boolean matches(EntityData ed) {
        return super.matches(ed) && (pattern == null || pattern.matcher(ed.getFields().getName()).matches());
    }

}
