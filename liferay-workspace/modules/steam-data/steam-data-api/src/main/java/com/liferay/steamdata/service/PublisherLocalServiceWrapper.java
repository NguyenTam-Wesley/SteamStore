/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link PublisherLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublisherLocalService
 * @generated
 */
public class PublisherLocalServiceWrapper
	implements PublisherLocalService, ServiceWrapper<PublisherLocalService> {

	public PublisherLocalServiceWrapper() {
		this(null);
	}

	public PublisherLocalServiceWrapper(
		PublisherLocalService publisherLocalService) {

		_publisherLocalService = publisherLocalService;
	}

	/**
	 * Adds the publisher to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublisherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publisher the publisher
	 * @return the publisher that was added
	 */
	@Override
	public com.liferay.steamdata.model.Publisher addPublisher(
		com.liferay.steamdata.model.Publisher publisher) {

		return _publisherLocalService.addPublisher(publisher);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publisherLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new publisher with the primary key. Does not add the publisher to the database.
	 *
	 * @param publisherId the primary key for the new publisher
	 * @return the new publisher
	 */
	@Override
	public com.liferay.steamdata.model.Publisher createPublisher(
		String publisherId) {

		return _publisherLocalService.createPublisher(publisherId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publisherLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the publisher from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublisherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publisher the publisher
	 * @return the publisher that was removed
	 */
	@Override
	public com.liferay.steamdata.model.Publisher deletePublisher(
		com.liferay.steamdata.model.Publisher publisher) {

		return _publisherLocalService.deletePublisher(publisher);
	}

	/**
	 * Deletes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublisherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws PortalException if a publisher with the primary key could not be found
	 */
	@Override
	public com.liferay.steamdata.model.Publisher deletePublisher(
			String publisherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publisherLocalService.deletePublisher(publisherId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _publisherLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _publisherLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publisherLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _publisherLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _publisherLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _publisherLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _publisherLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _publisherLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.steamdata.model.Publisher fetchPublisher(
		String publisherId) {

		return _publisherLocalService.fetchPublisher(publisherId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _publisherLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publisherLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the publisher with the primary key.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher
	 * @throws PortalException if a publisher with the primary key could not be found
	 */
	@Override
	public com.liferay.steamdata.model.Publisher getPublisher(
			String publisherId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publisherLocalService.getPublisher(publisherId);
	}

	/**
	 * Returns a range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of publishers
	 */
	@Override
	public java.util.List<com.liferay.steamdata.model.Publisher> getPublishers(
		int start, int end) {

		return _publisherLocalService.getPublishers(start, end);
	}

	/**
	 * Returns the number of publishers.
	 *
	 * @return the number of publishers
	 */
	@Override
	public int getPublishersCount() {
		return _publisherLocalService.getPublishersCount();
	}

	/**
	 * Updates the publisher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublisherLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publisher the publisher
	 * @return the publisher that was updated
	 */
	@Override
	public com.liferay.steamdata.model.Publisher updatePublisher(
		com.liferay.steamdata.model.Publisher publisher) {

		return _publisherLocalService.updatePublisher(publisher);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _publisherLocalService.getBasePersistence();
	}

	@Override
	public PublisherLocalService getWrappedService() {
		return _publisherLocalService;
	}

	@Override
	public void setWrappedService(PublisherLocalService publisherLocalService) {
		_publisherLocalService = publisherLocalService;
	}

	private PublisherLocalService _publisherLocalService;

}