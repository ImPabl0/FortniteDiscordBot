package br.pablo.fortnite.services;

import br.pablo.fortnite.models.UserContext;
import br.pablo.fortnite.models.fortnite.EntriesItem;
import br.pablo.fortnite.models.fortnite.ItemsItem;
import br.pablo.fortnite.models.fortnite.ShopData;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

@Service
public class EmbedService {

    @Autowired
    private UserContextService userContextService;

    @Autowired
    private ShopService shopService;

    public MessageEmbed viewLoja(ShopData shopData, int page) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Instant momentOfShop = Instant.parse(shopData.getDate()).plus(1, ChronoUnit.DAYS);
        int maxPages = shopData.getFeatured().getEntries().size();
        if(page <1) page=1;
        if(page > maxPages) page=maxPages;
        EntriesItem item = shopData.getFeatured().getEntries().get(page-1);
        return new EmbedBuilder()
                .setTitle(item.getBundle().getName())
                .setImage(item.getBundle().getImage())
                .setFooter(String.format("Página %d de %d - Dia %s", page, maxPages, sdf.format(Date.from(momentOfShop))))
                .setColor(Color.GREEN)
                .setDescription(item.getBundle().getInfo()).build();
    }

    public void onPreviousPageClicked(ButtonInteractionEvent event) {
        userContextService.previousPage(event.getUser().getId());
        event.deferEdit().queue();
        event.getMessage().editMessageEmbeds(
                viewLoja(shopService.getShopData(), userContextService.getContext(event.getUser().getId()).getCurrentPage())
        ).flatMap(message -> {
            boolean previousDisabled = userContextService.getContext(event.getUser().getId()).getCurrentPage() == 1;
            boolean nextDisabled = userContextService.getContext(event.getUser().getId()).getCurrentPage() == shopService.getShopData().getFeatured().getEntries().size();
            return message.editMessageComponents(
                    ActionRow.of(
                            Button.primary("previous_page","Voltar página").withEmoji(Emoji.fromUnicode("◀")).withDisabled(previousDisabled),
                            Button.success("next_page","Próxima página").withEmoji(Emoji.fromUnicode("▶")).withDisabled(nextDisabled)
                    )
            );
        }).queue();
    }
    public void onNextPageClicked(ButtonInteractionEvent event) {
        userContextService.nextPage(event.getUser().getId());
        event.deferEdit().queue();
        event.getMessage().editMessageEmbeds(
                viewLoja(shopService.getShopData(), userContextService.getContext(event.getUser().getId()).getCurrentPage())
        ).flatMap(message -> {
            boolean previousDisabled = userContextService.getContext(event.getUser().getId()).getCurrentPage() == 1;
            boolean nextDisabled = userContextService.getContext(event.getUser().getId()).getCurrentPage() == shopService.getShopData().getFeatured().getEntries().size();
            return message.editMessageComponents(
                    ActionRow.of(
                            Button.primary("previous_page","Voltar página").withEmoji(Emoji.fromUnicode("◀")).withDisabled(previousDisabled),
                            Button.success("next_page","Próxima página").withEmoji(Emoji.fromUnicode("▶")).withDisabled(nextDisabled)
                    )
            );
        }).queue();
    }

    public void sendLoja(GenericInteractionCreateEvent event){
        event.getUser().openPrivateChannel().queue((privateChannel)->{
            UserContext userContext=userContextService.getContext(event.getUser().getId());
            ShopData shopData=shopService.getShopData();
            boolean hasPreviousPage=userContext.getCurrentPage()>1;
            boolean hasNextPage=userContext.getCurrentPage()<shopData.getDaily().getEntries().getFirst().getItems().size();
            privateChannel.sendMessageEmbeds(viewLoja(shopData, userContext.getCurrentPage()))
                    .addActionRow(
                            Button.primary("previous_page","Voltar página").withEmoji(Emoji.fromUnicode("◀")).withDisabled(!hasPreviousPage),
                            Button.success("next_page","Próxima página").withEmoji(Emoji.fromUnicode("▶")).withDisabled(!hasNextPage)
                    ).queue();
        });
    }

}
