/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.steamdata.model.Publisher;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Publisher in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PublisherCacheModel
	implements CacheModel<Publisher>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PublisherCacheModel)) {
			return false;
		}

		PublisherCacheModel publisherCacheModel = (PublisherCacheModel)object;

		if (publisherId.equals(publisherCacheModel.publisherId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, publisherId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", publisherId=");
		sb.append(publisherId);
		sb.append(", publisherName=");
		sb.append(publisherName);
		sb.append(", linkWebsite=");
		sb.append(linkWebsite);
		sb.append(", publisherInfo=");
		sb.append(publisherInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Publisher toEntityModel() {
		PublisherImpl publisherImpl = new PublisherImpl();

		if (uuid == null) {
			publisherImpl.setUuid("");
		}
		else {
			publisherImpl.setUuid(uuid);
		}

		if (publisherId == null) {
			publisherImpl.setPublisherId("");
		}
		else {
			publisherImpl.setPublisherId(publisherId);
		}

		if (publisherName == null) {
			publisherImpl.setPublisherName("");
		}
		else {
			publisherImpl.setPublisherName(publisherName);
		}

		if (linkWebsite == null) {
			publisherImpl.setLinkWebsite("");
		}
		else {
			publisherImpl.setLinkWebsite(linkWebsite);
		}

		if (publisherInfo == null) {
			publisherImpl.setPublisherInfo("");
		}
		else {
			publisherImpl.setPublisherInfo(publisherInfo);
		}

		publisherImpl.resetOriginalValues();

		return publisherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		publisherId = objectInput.readUTF();
		publisherName = objectInput.readUTF();
		linkWebsite = objectInput.readUTF();
		publisherInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (publisherId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publisherId);
		}

		if (publisherName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publisherName);
		}

		if (linkWebsite == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(linkWebsite);
		}

		if (publisherInfo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publisherInfo);
		}
	}

	public String uuid;
	public String publisherId;
	public String publisherName;
	public String linkWebsite;
	public String publisherInfo;

}