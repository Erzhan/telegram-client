package kz.kaznu.telegramclient.services.telegram.handlers;

import java.util.List;
import java.util.logging.Logger;
import org.telegram.api.chat.TLAbsChat;
import org.telegram.api.message.TLAbsMessage;
import org.telegram.api.update.TLFakeUpdate;
import org.telegram.api.update.TLUpdateBotCallbackQuery;
import org.telegram.api.update.TLUpdateBotInlineQuery;
import org.telegram.api.update.TLUpdateBotInlineSend;
import org.telegram.api.update.TLUpdateBotPrecheckoutQuery;
import org.telegram.api.update.TLUpdateBotShippingQuery;
import org.telegram.api.update.TLUpdateBotWebhookJSON;
import org.telegram.api.update.TLUpdateBotWebhookJSONQuery;
import org.telegram.api.update.TLUpdateChannel;
import org.telegram.api.update.TLUpdateChannelMessageViews;
import org.telegram.api.update.TLUpdateChannelNewMessage;
import org.telegram.api.update.TLUpdateChannelPinnedMessage;
import org.telegram.api.update.TLUpdateChannelWebPage;
import org.telegram.api.update.TLUpdateChatAdmin;
import org.telegram.api.update.TLUpdateChatParticipantAdd;
import org.telegram.api.update.TLUpdateChatParticipantAdmin;
import org.telegram.api.update.TLUpdateChatParticipantDelete;
import org.telegram.api.update.TLUpdateChatParticipants;
import org.telegram.api.update.TLUpdateChatUserTyping;
import org.telegram.api.update.TLUpdateConfig;
import org.telegram.api.update.TLUpdateContactLink;
import org.telegram.api.update.TLUpdateContactRegistered;
import org.telegram.api.update.TLUpdateDcOptions;
import org.telegram.api.update.TLUpdateDeleteChannelMessages;
import org.telegram.api.update.TLUpdateDeleteMessages;
import org.telegram.api.update.TLUpdateDialogPinned;
import org.telegram.api.update.TLUpdateDraftMessage;
import org.telegram.api.update.TLUpdateEditChannelMessage;
import org.telegram.api.update.TLUpdateEditMessage;
import org.telegram.api.update.TLUpdateInlineBotCallbackQuery;
import org.telegram.api.update.TLUpdateMessageId;
import org.telegram.api.update.TLUpdateNewMessage;
import org.telegram.api.update.TLUpdateNewStickerSet;
import org.telegram.api.update.TLUpdateNotifySettings;
import org.telegram.api.update.TLUpdatePhoneCall;
import org.telegram.api.update.TLUpdatePinnedDialogs;
import org.telegram.api.update.TLUpdatePrivacy;
import org.telegram.api.update.TLUpdatePtsChanged;
import org.telegram.api.update.TLUpdateReadChannelInbox;
import org.telegram.api.update.TLUpdateReadChannelOutbox;
import org.telegram.api.update.TLUpdateReadFeaturedStickers;
import org.telegram.api.update.TLUpdateReadMessagesContents;
import org.telegram.api.update.TLUpdateReadMessagesInbox;
import org.telegram.api.update.TLUpdateReadMessagesOutbox;
import org.telegram.api.update.TLUpdateRecentStickers;
import org.telegram.api.update.TLUpdateSavedGifs;
import org.telegram.api.update.TLUpdateServiceNotification;
import org.telegram.api.update.TLUpdateStickerSets;
import org.telegram.api.update.TLUpdateStickerSetsOrder;
import org.telegram.api.update.TLUpdateUserBlocked;
import org.telegram.api.update.TLUpdateUserName;
import org.telegram.api.update.TLUpdateUserPhone;
import org.telegram.api.update.TLUpdateUserPhoto;
import org.telegram.api.update.TLUpdateUserStatus;
import org.telegram.api.update.TLUpdateUserTyping;
import org.telegram.api.update.TLUpdateWebPage;
import org.telegram.api.update.encrypted.TLUpdateEncryptedChatTyping;
import org.telegram.api.update.encrypted.TLUpdateEncryptedMessagesRead;
import org.telegram.api.update.encrypted.TLUpdateEncryption;
import org.telegram.api.update.encrypted.TLUpdateNewEncryptedMessage;
import org.telegram.api.updates.TLUpdateShortChatMessage;
import org.telegram.api.updates.TLUpdateShortMessage;
import org.telegram.api.updates.TLUpdateShortSentMessage;
import org.telegram.api.user.TLAbsUser;
import org.telegram.bot.handlers.DefaultUpdatesHandler;
import org.telegram.bot.kernel.IKernelComm;
import org.telegram.bot.kernel.database.DatabaseManager;
import org.telegram.bot.kernel.differenceparameters.IDifferenceParametersService;

/**
 * Created by yerzhan on 10/9/19.
 */
public class CustomUpdatesHandler extends DefaultUpdatesHandler {

  private Logger logger = java.util.logging.Logger
      .getLogger(CustomUpdatesHandler.class.getSimpleName());

  private UsersHandlerImpl usersHandler;
  private ChatsHandlerImpl chatsHandler;
  private MessageHandler messageHandler;


  public CustomUpdatesHandler(IKernelComm kernelComm,
      IDifferenceParametersService differenceParametersService,
      DatabaseManager databaseManager) {
    super(kernelComm, differenceParametersService, databaseManager);
  }


  @Override
  public void onTLUpdateChatParticipantsCustom(TLUpdateChatParticipants update) {
    logger.fine("onTLUpdateChatParticipantsCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateNewMessageCustom(TLUpdateNewMessage update) {
    logger.fine("onTLUpdateNewMessageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChannelNewMessageCustom(TLUpdateChannelNewMessage update) {
    logger.fine("onTLUpdateChannelNewMessageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChannelCustom(TLUpdateChannel update) {
    logger.fine("onTLUpdateChannelCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotInlineQueryCustom(TLUpdateBotInlineQuery update) {
    logger.fine("onTLUpdateBotInlineQueryCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotInlineSendCustom(TLUpdateBotInlineSend update) {
    logger.fine("onTLUpdateBotInlineSendCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChannelMessageViewsCustom(TLUpdateChannelMessageViews update) {
    logger.fine("onTLUpdateChannelMessageViewsCustom = " + update.getChannelId());
  }

  @Override
  public void onTLUpdateChannelPinnedMessageCustom(TLUpdateChannelPinnedMessage update) {
    logger.fine("onTLUpdateChannelPinnedMessageCustom = " + update.getChannelId());
  }

  @Override
  public void onTLUpdateChatAdminCustom(TLUpdateChatAdmin update) {
    logger.fine("onTLUpdateChatAdminCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChatParticipantAddCustom(TLUpdateChatParticipantAdd update) {
    logger.fine("onTLUpdateChatParticipantAddCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChatParticipantAdminCustom(TLUpdateChatParticipantAdmin update) {
    logger.fine("onTLUpdateChatParticipantAdminCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChatParticipantDeleteCustom(TLUpdateChatParticipantDelete update) {
    logger.fine("onTLUpdateChatParticipantDeleteCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChatUserTypingCustom(TLUpdateChatUserTyping update) {
    logger.fine("onTLUpdateChatUserTypingCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateContactLinkCustom(TLUpdateContactLink update) {
    logger.fine("onTLUpdateContactLinkCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateContactRegisteredCustom(TLUpdateContactRegistered update) {
    logger.fine("onTLUpdateContactRegisteredCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateDcOptionsCustom(TLUpdateDcOptions update) {
    logger.fine("onTLUpdateDcOptionsCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateDeleteChannelMessagesCustom(TLUpdateDeleteChannelMessages update) {
    logger.fine("onTLUpdateDeleteChannelMessagesCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateDeleteMessagesCustom(TLUpdateDeleteMessages update) {
    logger.fine("onTLUpdateDeleteMessagesCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateEditChannelMessageCustom(TLUpdateEditChannelMessage update) {
    logger.fine("onTLUpdateEditChannelMessageCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateMessageIdCustom(TLUpdateMessageId update) {
    logger.fine("onTLUpdateMessageIdCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateNewStickerSetCustom(TLUpdateNewStickerSet update) {
    logger.fine("onTLUpdateNewStickerSetCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateNotifySettingsCustom(TLUpdateNotifySettings update) {
    logger.fine("onTLUpdateNotifySettingsCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdatePrivacyCustom(TLUpdatePrivacy update) {
    logger.fine("onTLUpdatePrivacyCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateReadChannelInboxCustom(TLUpdateReadChannelInbox update) {
    logger.fine("onTLUpdateReadChannelInboxCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateReadMessagesContentsCustom(TLUpdateReadMessagesContents update) {
    logger.fine("onTLUpdateReadMessagesContentsCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateReadMessagesInboxCustom(TLUpdateReadMessagesInbox update) {
    logger.fine("onTLUpdateReadMessagesInboxCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateReadMessagesOutboxCustom(TLUpdateReadMessagesOutbox update) {
    logger.fine("onTLUpdateReadMessagesOutboxCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateSavedGifsCustom(TLUpdateSavedGifs update) {
    logger.fine("onTLUpdateSavedGifsCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateServiceNotificationCustom(TLUpdateServiceNotification update) {
    logger.fine("onTLUpdateServiceNotificationCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateStickerSetsCustom(TLUpdateStickerSets update) {
    logger.fine("onTLUpdateStickerSetsCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateStickerSetsOrderCustom(TLUpdateStickerSetsOrder update) {
    logger.fine("onTLUpdateStickerSetsOrderCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserBlockedCustom(TLUpdateUserBlocked update) {
    logger.fine("onTLUpdateUserBlockedCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserNameCustom(TLUpdateUserName update) {
    logger.fine("onTLUpdateUserNameCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserPhoneCustom(TLUpdateUserPhone update) {
    logger.fine("onTLUpdateUserPhoneCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserPhotoCustom(TLUpdateUserPhoto update) {
    logger.fine("onTLUpdateUserPhotoCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserStatusCustom(TLUpdateUserStatus update) {
    logger.fine("onTLUpdateUserStatusCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateUserTypingCustom(TLUpdateUserTyping update) {
    logger.fine("onTLUpdateUserTypingCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateWebPageCustom(TLUpdateWebPage update) {
    logger.fine("onTLUpdateWebPageCustom = " + update.toString());
  }

  @Override
  protected void onTLFakeUpdateCustom(TLFakeUpdate update) {
    logger.fine("onTLFakeUpdateCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateShortMessageCustom(TLUpdateShortMessage update) {
    logger.fine("onTLUpdateShortMessageCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateShortChatMessageCustom(TLUpdateShortChatMessage update) {
    messageHandler.onMessage(update);
  }

  @Override
  protected void onTLUpdateShortSentMessageCustom(TLUpdateShortSentMessage update) {
    logger.fine("onTLUpdateShortSentMessageCustom = " + update.toString());
  }

  @Override
  protected void onTLAbsMessageCustom(TLAbsMessage message) {
    messageHandler.onMessage(message);
  }

  @Override
  protected void onUsersCustom(List<TLAbsUser> users) {
    usersHandler.onUsers(users);
  }

  @Override
  protected void onChatsCustom(List<TLAbsChat> chats) {
    chatsHandler.onChats(chats);
  }

  @Override
  protected void onTLUpdateEncryptionCustom(TLUpdateEncryption update) {
    logger.fine("onTLUpdateEncryptionCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateEncryptedMessagesReadCustom(TLUpdateEncryptedMessagesRead update) {
    logger.fine("onTLUpdateEncryptedMessagesReadCustom = " + update.toString());
  }

  @Override
  protected void onTLUpdateNewEncryptedMessageCustom(TLUpdateNewEncryptedMessage update) {
    logger.fine("onTLUpdateNewEncryptedMessageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateEncryptedChatTypingCustom(TLUpdateEncryptedChatTyping update) {
    logger.fine("onTLUpdateEncryptedChatTypingCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateConfigCustom(TLUpdateConfig update) {
    logger.fine("onTLUpdateConfigCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateDraftMessageCustom(TLUpdateDraftMessage update) {
    logger.fine("onTLUpdateDraftMessageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdatePtsChangedCustom(TLUpdatePtsChanged update) {
    logger.fine("onTLUpdatePtsChangedCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateReadChannelOutboxCustom(TLUpdateReadChannelOutbox update) {
    logger.fine("onTLUpdateReadChannelOutboxCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateReadFeaturedStickersCustom(TLUpdateReadFeaturedStickers update) {
    logger.fine("onTLUpdateReadFeaturedStickersCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateRecentStickersCustom(TLUpdateRecentStickers update) {
    logger.fine("onTLUpdateRecentStickersCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotCallbackQueryCustom(TLUpdateBotCallbackQuery update) {
    logger.fine("onTLUpdateBotCallbackQueryCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateEditMessageCustom(TLUpdateEditMessage update) {
    logger.fine("onTLUpdateEditMessageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateInlineBotCallbackQueryCustom(TLUpdateInlineBotCallbackQuery update) {
    logger.fine("onTLUpdateInlineBotCallbackQueryCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateChannelWebPageCustom(TLUpdateChannelWebPage update) {
    logger.fine("onTLUpdateChannelWebPageCustom = " + update.toString());
  }

  @Override
  public void onTLUpdatePhoneCallCustom(TLUpdatePhoneCall update) {
    logger.fine("onTLUpdatePhoneCallCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateDialogPinnedCustom(TLUpdateDialogPinned update) {
    logger.fine("onTLUpdateDialogPinnedCustom = " + update.toString());
  }

  @Override
  public void onTLUpdatePinnedDialogsCustom(TLUpdatePinnedDialogs update) {
    logger.fine("onTLUpdatePinnedDialogsCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotWebhookJSONCustom(TLUpdateBotWebhookJSON update) {
    logger.fine("onTLUpdateBotWebhookJSONCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotWebhookJSONQueryCustom(TLUpdateBotWebhookJSONQuery update) {
    logger.fine("onTLUpdateBotWebhookJSONQueryCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotShippingQueryCustom(TLUpdateBotShippingQuery update) {
    logger.fine("onTLUpdateBotShippingQueryCustom = " + update.toString());
  }

  @Override
  public void onTLUpdateBotPrecheckoutQueryCustom(TLUpdateBotPrecheckoutQuery update) {
    logger.fine("onTLUpdateBotPrecheckoutQueryCustom = " + update.toString());
  }

  public void setUsersHandler(UsersHandlerImpl usersHandler) {
    this.usersHandler = usersHandler;
  }

  public void setChatsHandler(ChatsHandlerImpl chatsHandler) {
    this.chatsHandler = chatsHandler;
  }

  public void setMessageHandler(MessageHandler messageHandler) {
    this.messageHandler = messageHandler;
  }
}
