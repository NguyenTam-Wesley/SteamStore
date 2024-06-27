/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Publisher service. Represents a row in the &quot;Liferay_Publisher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.steamdata.model.impl.PublisherModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.steamdata.model.impl.PublisherImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Publisher
 * @generated
 */
@ProviderType
public interface PublisherModel extends BaseModel<Publisher> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a publisher model instance should use the {@link Publisher} interface instead.
	 */

	/**
	 * Returns the primary key of this publisher.
	 *
	 * @return the primary key of this publisher
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this publisher.
	 *
	 * @param primaryKey the primary key of this publisher
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this publisher.
	 *
	 * @return the uuid of this publisher
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this publisher.
	 *
	 * @param uuid the uuid of this publisher
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the publisher ID of this publisher.
	 *
	 * @return the publisher ID of this publisher
	 */
	@AutoEscape
	public String getPublisherId();

	/**
	 * Sets the publisher ID of this publisher.
	 *
	 * @param publisherId the publisher ID of this publisher
	 */
	public void setPublisherId(String publisherId);

	/**
	 * Returns the publisher name of this publisher.
	 *
	 * @return the publisher name of this publisher
	 */
	@AutoEscape
	public String getPublisherName();

	/**
	 * Sets the publisher name of this publisher.
	 *
	 * @param publisherName the publisher name of this publisher
	 */
	public void setPublisherName(String publisherName);

	/**
	 * Returns the link website of this publisher.
	 *
	 * @return the link website of this publisher
	 */
	@AutoEscape
	public String getLinkWebsite();

	/**
	 * Sets the link website of this publisher.
	 *
	 * @param linkWebsite the link website of this publisher
	 */
	public void setLinkWebsite(String linkWebsite);

	/**
	 * Returns the publisher info of this publisher.
	 *
	 * @return the publisher info of this publisher
	 */
	@AutoEscape
	public String getPublisherInfo();

	/**
	 * Sets the publisher info of this publisher.
	 *
	 * @param publisherInfo the publisher info of this publisher
	 */
	public void setPublisherInfo(String publisherInfo);

	@Override
	public Publisher cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}