/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.steamdata.exception.NoSuchPublisherException;
import com.liferay.steamdata.model.Publisher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the publisher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PublisherUtil
 * @generated
 */
@ProviderType
public interface PublisherPersistence extends BasePersistence<Publisher> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublisherUtil} to access the publisher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching publishers
	 */
	public java.util.List<Publisher> findByUuid(String uuid);

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
	public java.util.List<Publisher> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Publisher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator);

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
	public java.util.List<Publisher> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	public Publisher findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Publisher>
				orderByComparator)
		throws NoSuchPublisherException;

	/**
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	public Publisher fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator);

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	public Publisher findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Publisher>
				orderByComparator)
		throws NoSuchPublisherException;

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	public Publisher fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator);

	/**
	 * Returns the publishers before and after the current publisher in the ordered set where uuid = &#63;.
	 *
	 * @param publisherId the primary key of the current publisher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public Publisher[] findByUuid_PrevAndNext(
			String publisherId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Publisher>
				orderByComparator)
		throws NoSuchPublisherException;

	/**
	 * Removes all the publishers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching publishers
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the publisher in the entity cache if it is enabled.
	 *
	 * @param publisher the publisher
	 */
	public void cacheResult(Publisher publisher);

	/**
	 * Caches the publishers in the entity cache if it is enabled.
	 *
	 * @param publishers the publishers
	 */
	public void cacheResult(java.util.List<Publisher> publishers);

	/**
	 * Creates a new publisher with the primary key. Does not add the publisher to the database.
	 *
	 * @param publisherId the primary key for the new publisher
	 * @return the new publisher
	 */
	public Publisher create(String publisherId);

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public Publisher remove(String publisherId) throws NoSuchPublisherException;

	public Publisher updateImpl(Publisher publisher);

	/**
	 * Returns the publisher with the primary key or throws a <code>NoSuchPublisherException</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	public Publisher findByPrimaryKey(String publisherId)
		throws NoSuchPublisherException;

	/**
	 * Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	 */
	public Publisher fetchByPrimaryKey(String publisherId);

	/**
	 * Returns all the publishers.
	 *
	 * @return the publishers
	 */
	public java.util.List<Publisher> findAll();

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
	public java.util.List<Publisher> findAll(int start, int end);

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
	public java.util.List<Publisher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator);

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
	public java.util.List<Publisher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Publisher>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the publishers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of publishers.
	 *
	 * @return the number of publishers
	 */
	public int countAll();

}