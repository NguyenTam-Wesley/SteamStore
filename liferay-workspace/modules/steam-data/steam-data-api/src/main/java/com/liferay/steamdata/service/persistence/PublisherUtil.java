/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.steamdata.model.Publisher;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the publisher service. This utility wraps <code>com.liferay.steamdata.service.persistence.impl.PublisherPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublisherPersistence
 * @generated
 */
public class PublisherUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Publisher publisher) {
		getPersistence().clearCache(publisher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Publisher> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Publisher> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Publisher update(Publisher publisher) {
		return getPersistence().update(publisher);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Publisher update(
		Publisher publisher, ServiceContext serviceContext) {

		return getPersistence().update(publisher, serviceContext);
	}

	/**
	 * Returns all the publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching publishers
	 */
	public static List<Publisher> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of matching publishers
	 */
	public static List<Publisher> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publishers
	 */
	public static List<Publisher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Publisher> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching publishers
	 */
	public static List<Publisher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Publisher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	public static Publisher findByUuid_First(
			String uuid, OrderByComparator<Publisher> orderByComparator)
		throws com.liferay.steamdata.exception.NoSuchPublisherException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	public static Publisher fetchByUuid_First(
		String uuid, OrderByComparator<Publisher> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	public static Publisher findByUuid_Last(
			String uuid, OrderByComparator<Publisher> orderByComparator)
		throws com.liferay.steamdata.exception.NoSuchPublisherException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	public static Publisher fetchByUuid_Last(
		String uuid, OrderByComparator<Publisher> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the publishers before and after the current publisher in the ordered set where uuid = &#63;.
	 *
	 * @param publisherId the primary key of the current publisher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public static Publisher[] findByUuid_PrevAndNext(
			String publisherId, String uuid,
			OrderByComparator<Publisher> orderByComparator)
		throws com.liferay.steamdata.exception.NoSuchPublisherException {

		return getPersistence().findByUuid_PrevAndNext(
			publisherId, uuid, orderByComparator);
	}

	/**
	 * Removes all the publishers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching publishers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the publisher in the entity cache if it is enabled.
	 *
	 * @param publisher the publisher
	 */
	public static void cacheResult(Publisher publisher) {
		getPersistence().cacheResult(publisher);
	}

	/**
	 * Caches the publishers in the entity cache if it is enabled.
	 *
	 * @param publishers the publishers
	 */
	public static void cacheResult(List<Publisher> publishers) {
		getPersistence().cacheResult(publishers);
	}

	/**
	 * Creates a new publisher with the primary key. Does not add the publisher to the database.
	 *
	 * @param publisherId the primary key for the new publisher
	 * @return the new publisher
	 */
	public static Publisher create(String publisherId) {
		return getPersistence().create(publisherId);
	}

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public static Publisher remove(String publisherId)
		throws com.liferay.steamdata.exception.NoSuchPublisherException {

		return getPersistence().remove(publisherId);
	}

	public static Publisher updateImpl(Publisher publisher) {
		return getPersistence().updateImpl(publisher);
	}

	/**
	 * Returns the publisher with the primary key or throws a <code>NoSuchPublisherException</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public static Publisher findByPrimaryKey(String publisherId)
		throws com.liferay.steamdata.exception.NoSuchPublisherException {

		return getPersistence().findByPrimaryKey(publisherId);
	}

	/**
	 * Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	 */
	public static Publisher fetchByPrimaryKey(String publisherId) {
		return getPersistence().fetchByPrimaryKey(publisherId);
	}

	/**
	 * Returns all the publishers.
	 *
	 * @return the publishers
	 */
	public static List<Publisher> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of publishers
	 */
	public static List<Publisher> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publishers
	 */
	public static List<Publisher> findAll(
		int start, int end, OrderByComparator<Publisher> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of publishers
	 */
	public static List<Publisher> findAll(
		int start, int end, OrderByComparator<Publisher> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the publishers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of publishers.
	 *
	 * @return the number of publishers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PublisherPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PublisherPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PublisherPersistence _persistence;

}