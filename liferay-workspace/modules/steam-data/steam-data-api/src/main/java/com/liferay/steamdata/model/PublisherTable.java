/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;Liferay_Publisher&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Publisher
 * @generated
 */
public class PublisherTable extends BaseTable<PublisherTable> {

	public static final PublisherTable INSTANCE = new PublisherTable();

	public final Column<PublisherTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublisherTable, String> publisherId = createColumn(
		"publisherId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<PublisherTable, String> publisherName = createColumn(
		"publisherName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublisherTable, String> linkWebsite = createColumn(
		"linkWebsite", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublisherTable, String> publisherInfo = createColumn(
		"publisherInfo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PublisherTable() {
		super("Liferay_Publisher", PublisherTable::new);
	}

}