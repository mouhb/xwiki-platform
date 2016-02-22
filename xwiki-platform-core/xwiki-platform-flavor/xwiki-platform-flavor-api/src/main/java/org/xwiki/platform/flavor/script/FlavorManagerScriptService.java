/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.platform.flavor.script;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.extension.Extension;
import org.xwiki.extension.ExtensionId;
import org.xwiki.extension.repository.result.IterableResult;
import org.xwiki.platform.flavor.FlavorManager;
import org.xwiki.platform.flavor.FlavorQuery;
import org.xwiki.script.service.ScriptService;
import org.xwiki.stability.Unstable;

/**
 * Script service to find flavors.
 * 
 * @version $Id$
 * @since 7.1M2
 */
@Component
@Named("flavor")
@Singleton
@Unstable
public class FlavorManagerScriptService implements ScriptService
{
    @Inject
    private FlavorManager flavorManager;

    /**
     * Creates a flavor query.
     * 
     * @return a new flavor query
     */
    public FlavorQuery createFlavorQuery()
    {
        return new FlavorQuery();
    }

    /**
     * Creates a flavor query.
     * 
     * @param query the query to execute
     * @return a new flavor query
     */
    public FlavorQuery createFlavorQuery(String query)
    {
        return new FlavorQuery(query);
    }

    /**
     * Get all flavors matching a query.
     * 
     * @param query query to execute
     * @return flavors matching the query
     * @deprecated since 8.0M2, use {@link #search(FlavorQuery)} instead
     */
    @Deprecated
    public IterableResult<Extension> getFlavors(FlavorQuery query)
    {
        return this.flavorManager.getFlavors(query);
    }

    /**
     * Get all flavors matching a query.
     * 
     * @param query query to execute
     * @return flavors matching the query
     * @since 8.0M2
     */
    public IterableResult<Extension> search(FlavorQuery query)
    {
        return this.flavorManager.search(query);
    }

    /**
     * Get the flavor installed on a given wiki.
     * 
     * @param wikiId id of the wiki
     * @return the id of the flavor installed on the given wiki or null if there is no flavor installed
     */
    public ExtensionId getFlavorOfWiki(String wikiId)
    {
        return this.flavorManager.getFlavorOfWiki(wikiId);
    }
}
