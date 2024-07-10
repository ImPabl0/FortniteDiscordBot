package br.pablo.fortnite;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JDAProvider {

    @Value("${discord.bot.token}")
    String token;

    @Bean
    public JDA jda() throws InterruptedException {
        return JDABuilder.create(token,
                 GatewayIntent.DIRECT_MESSAGES
                ,GatewayIntent.GUILD_MESSAGES
                ,GatewayIntent.MESSAGE_CONTENT).build().awaitReady();
    }

}
