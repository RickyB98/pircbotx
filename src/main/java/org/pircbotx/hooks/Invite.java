/**
 * Copyright (C) 2010 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PircBotX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PircBotX.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks;

import org.pircbotx.hooks.helpers.BaseEvent;
import org.pircbotx.hooks.helpers.BaseListener;
import org.pircbotx.hooks.helpers.BaseSimpleListener;

/**
 * Called when we are invited to a channel by a user.
 *  <p>
 * The implementation of this method in the PircBotX abstract class
 * performs no actions and may be overridden as required.
 * @author Leon Blakey <lord.quackstar at gmail.com>
 */
public class Invite {
	/**
	 * Simple listener that takes event parameters as parameters. See 
	 * {@link Invite} for an explanation on use 
	 * @see Invite 
	 */
	public static interface SimpleListener extends BaseSimpleListener {
		public void onInvite(String targetNick, String sourceNick, String sourceLogin, String sourceHostname, String channel);
	}

	/**
	 * Listener that receives an event. See {@link Invite} for an explanation 
	 * on use and {@link Event} for an explanation on the event. 
	 * @see Invite 
	 * @see Event 
	 */
	public static interface Listener extends BaseListener {
		public void onInvite(Event event);
	}

	/**
	 * Event that is passed to all listeners that contains all the given
	 * information. See {@link Invite} for an explanation on when this is created
	 * <p>
	 * <b>Note:<b> This class and all its subclasses are immutable since
	 * data should not change after creation
	 * @see Invite 
	 * @see Listener
	 */
	public static class Event implements BaseEvent {
		protected final long timestamp;
		protected final String targetNick;
		protected final String sourceNick;
		protected final String sourceLogin;
		protected final String sourceHostname;
		protected final String channel;

		/**
		 * Default constructor to setup object. Timestamp is automatically set
		 * to current time as reported by {@link System#currentTimeMillis() }
		 * @param targetNick The nick of the user being invited - should be us!
		 * @param sourceNick The nick of the user that sent the invitation.
		 * @param sourceLogin The login of the user that sent the invitation.
		 * @param sourceHostname The hostname of the user that sent the invitation.
		 * @param channel The channel that we're being invited to.
		 */
		public Event(String targetNick, String sourceNick, String sourceLogin, String sourceHostname, String channel) {
			this.timestamp = System.currentTimeMillis();
			this.targetNick = targetNick;
			this.sourceNick = sourceNick;
			this.sourceLogin = sourceLogin;
			this.sourceHostname = sourceHostname;
			this.channel = channel;
		}

		public String getChannel() {
			return channel;
		}

		public String getSourceHostname() {
			return sourceHostname;
		}

		public String getSourceLogin() {
			return sourceLogin;
		}

		public String getSourceNick() {
			return sourceNick;
		}

		public String getTargetNick() {
			return targetNick;
		}

		public long getTimestamp() {
			return timestamp;
		}
	}
}
