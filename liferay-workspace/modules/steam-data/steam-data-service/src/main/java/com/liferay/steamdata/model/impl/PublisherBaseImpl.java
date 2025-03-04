/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model.impl;

import com.liferay.steamdata.model.Publisher;
import com.liferay.steamdata.service.PublisherLocalServiceUtil;

/**
 * The extended model base implementation for the Publisher service. Represents a row in the &quot;Liferay_Publisher&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PublisherImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublisherImpl
 * @see Publisher
 * @generated
 */
public abstract class PublisherBaseImpl
	extends PublisherModelImpl implements Publisher {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a publisher model instance should use the <code>Publisher</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PublisherLocalServiceUtil.addPublisher(this);
		}
		else {
			PublisherLocalServiceUtil.updatePublisher(this);
		}
	}

}