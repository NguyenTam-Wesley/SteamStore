/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Liferay_Game&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Game
 * @generated
 */
public class GameTable extends BaseTable<GameTable> {

	public static final GameTable INSTANCE = new GameTable();

	public final Column<GameTable, Long> appId = createColumn(
		"appId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<GameTable, String> publisherId = createColumn(
		"publisherId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GameTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GameTable, Date> releaseDate = createColumn(
		"releaseDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GameTable, Double> price = createColumn(
		"price", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<GameTable, String> aboutDescription = createColumn(
		"aboutDescription", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private GameTable() {
		super("Liferay_Game", GameTable::new);
	}

}