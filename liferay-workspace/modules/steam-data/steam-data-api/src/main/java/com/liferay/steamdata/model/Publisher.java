/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Publisher service. Represents a row in the &quot;Liferay_Publisher&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PublisherModel
 * @generated
 */
@ImplementationClassName("com.liferay.steamdata.model.impl.PublisherImpl")
@ProviderType
public interface Publisher extends PersistedModel, PublisherModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.steamdata.model.impl.PublisherImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Publisher, String> PUBLISHER_ID_ACCESSOR =
		new Accessor<Publisher, String>() {

			@Override
			public String get(Publisher publisher) {
				return publisher.getPublisherId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<Publisher> getTypeClass() {
				return Publisher.class;
			}

		};

}