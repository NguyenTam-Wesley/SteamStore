/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.steamdata.model.Game;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Game in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class GameCacheModel implements CacheModel<Game>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GameCacheModel)) {
			return false;
		}

		GameCacheModel gameCacheModel = (GameCacheModel)object;

		if (appId == gameCacheModel.appId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{appId=");
		sb.append(appId);
		sb.append(", publisherId=");
		sb.append(publisherId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append(", price=");
		sb.append(price);
		sb.append(", aboutDescription=");
		sb.append(aboutDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Game toEntityModel() {
		GameImpl gameImpl = new GameImpl();

		gameImpl.setAppId(appId);

		if (publisherId == null) {
			gameImpl.setPublisherId("");
		}
		else {
			gameImpl.setPublisherId(publisherId);
		}

		if (title == null) {
			gameImpl.setTitle("");
		}
		else {
			gameImpl.setTitle(title);
		}

		if (releaseDate == Long.MIN_VALUE) {
			gameImpl.setReleaseDate(null);
		}
		else {
			gameImpl.setReleaseDate(new Date(releaseDate));
		}

		gameImpl.setPrice(price);

		if (aboutDescription == null) {
			gameImpl.setAboutDescription("");
		}
		else {
			gameImpl.setAboutDescription(aboutDescription);
		}

		gameImpl.resetOriginalValues();

		return gameImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		appId = objectInput.readLong();
		publisherId = objectInput.readUTF();
		title = objectInput.readUTF();
		releaseDate = objectInput.readLong();

		price = objectInput.readDouble();
		aboutDescription = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(appId);

		if (publisherId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publisherId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(releaseDate);

		objectOutput.writeDouble(price);

		if (aboutDescription == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(aboutDescription);
		}
	}

	public long appId;
	public String publisherId;
	public String title;
	public long releaseDate;
	public double price;
	public String aboutDescription;

}