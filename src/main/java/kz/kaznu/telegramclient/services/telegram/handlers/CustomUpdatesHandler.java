package kz.kaznu.telegramclient.services.telegram.handlers;

import java.util.List;
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

  private UsersHandlerImpl usersHandler;
  private ChatsHandlerImpl chatsHandler;


  public CustomUpdatesHandler(IKernelComm kernelComm,
      IDifferenceParametersService differenceParametersService,
      DatabaseManager databaseManager) {
    super(kernelComm, differenceParametersService, databaseManager);
  }


  @Override
  public void onTLUpdateChatParticipantsCustom(TLUpdateChatParticipants update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateNewMessageCustom(TLUpdateNewMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateChannelNewMessageCustom(TLUpdateChannelNewMessage update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdateChannelCustom(TLUpdateChannel update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdateBotInlineQueryCustom(TLUpdateBotInlineQuery update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotInlineSendCustom(TLUpdateBotInlineSend update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateChannelMessageViewsCustom(TLUpdateChannelMessageViews update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdateChannelPinnedMessageCustom(TLUpdateChannelPinnedMessage update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdateChatAdminCustom(TLUpdateChatAdmin update) {
    System.out.println(update.getChatId());
  }

  @Override
  public void onTLUpdateChatParticipantAddCustom(TLUpdateChatParticipantAdd update) {
    System.out.println(update.getChatId());
  }

  @Override
  public void onTLUpdateChatParticipantAdminCustom(TLUpdateChatParticipantAdmin update) {
    System.out.println(update.getChatId());
  }

  @Override
  public void onTLUpdateChatParticipantDeleteCustom(TLUpdateChatParticipantDelete update) {
    System.out.println(update.getChatId());
  }

  @Override
  public void onTLUpdateChatUserTypingCustom(TLUpdateChatUserTyping update) {
    System.out.println(update.getChatId());
  }

  @Override
  public void onTLUpdateContactLinkCustom(TLUpdateContactLink update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateContactRegisteredCustom(TLUpdateContactRegistered update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateDcOptionsCustom(TLUpdateDcOptions update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateDeleteChannelMessagesCustom(TLUpdateDeleteChannelMessages update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateDeleteMessagesCustom(TLUpdateDeleteMessages update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateEditChannelMessageCustom(TLUpdateEditChannelMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateMessageIdCustom(TLUpdateMessageId update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateNewStickerSetCustom(TLUpdateNewStickerSet update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateNotifySettingsCustom(TLUpdateNotifySettings update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdatePrivacyCustom(TLUpdatePrivacy update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateReadChannelInboxCustom(TLUpdateReadChannelInbox update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateReadMessagesContentsCustom(TLUpdateReadMessagesContents update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateReadMessagesInboxCustom(TLUpdateReadMessagesInbox update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateReadMessagesOutboxCustom(TLUpdateReadMessagesOutbox update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateSavedGifsCustom(TLUpdateSavedGifs update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateServiceNotificationCustom(TLUpdateServiceNotification update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateStickerSetsCustom(TLUpdateStickerSets update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateStickerSetsOrderCustom(TLUpdateStickerSetsOrder update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserBlockedCustom(TLUpdateUserBlocked update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserNameCustom(TLUpdateUserName update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserPhoneCustom(TLUpdateUserPhone update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserPhotoCustom(TLUpdateUserPhoto update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserStatusCustom(TLUpdateUserStatus update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateUserTypingCustom(TLUpdateUserTyping update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateWebPageCustom(TLUpdateWebPage update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLFakeUpdateCustom(TLFakeUpdate update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateShortMessageCustom(TLUpdateShortMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateShortChatMessageCustom(TLUpdateShortChatMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateShortSentMessageCustom(TLUpdateShortSentMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLAbsMessageCustom(TLAbsMessage message) {
    System.out.println(message.getChatId());
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
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateEncryptedMessagesReadCustom(TLUpdateEncryptedMessagesRead update) {
    System.out.println(update.getClassId());
  }

  @Override
  protected void onTLUpdateNewEncryptedMessageCustom(TLUpdateNewEncryptedMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateEncryptedChatTypingCustom(TLUpdateEncryptedChatTyping update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateConfigCustom(TLUpdateConfig update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateDraftMessageCustom(TLUpdateDraftMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdatePtsChangedCustom(TLUpdatePtsChanged update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateReadChannelOutboxCustom(TLUpdateReadChannelOutbox update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdateReadFeaturedStickersCustom(TLUpdateReadFeaturedStickers update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateRecentStickersCustom(TLUpdateRecentStickers update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotCallbackQueryCustom(TLUpdateBotCallbackQuery update) {
    System.out.println(update.getChatInstance());
  }

  @Override
  public void onTLUpdateEditMessageCustom(TLUpdateEditMessage update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateInlineBotCallbackQueryCustom(TLUpdateInlineBotCallbackQuery update) {
    System.out.println(update.getChatInstance());
  }

  @Override
  public void onTLUpdateChannelWebPageCustom(TLUpdateChannelWebPage update) {
    System.out.println(update.getChannelId());
  }

  @Override
  public void onTLUpdatePhoneCallCustom(TLUpdatePhoneCall update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateDialogPinnedCustom(TLUpdateDialogPinned update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdatePinnedDialogsCustom(TLUpdatePinnedDialogs update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotWebhookJSONCustom(TLUpdateBotWebhookJSON update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotWebhookJSONQueryCustom(TLUpdateBotWebhookJSONQuery update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotShippingQueryCustom(TLUpdateBotShippingQuery update) {
    System.out.println(update.getClassId());
  }

  @Override
  public void onTLUpdateBotPrecheckoutQueryCustom(TLUpdateBotPrecheckoutQuery update) {
    System.out.println(update.getClassId());
  }

  public void setUsersHandler(UsersHandlerImpl usersHandler) {
    this.usersHandler = usersHandler;
  }

  public void setChatsHandler(ChatsHandlerImpl chatsHandler) {
    this.chatsHandler = chatsHandler;
  }
}
